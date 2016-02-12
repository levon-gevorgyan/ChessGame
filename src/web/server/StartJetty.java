package web.server;
import java.io.File;
import java.lang.management.ManagementFactory;

import org.eclipse.jetty.jmx.MBeanContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import web.game.Room;
import web.socket.PlayChessSocket;


/**
 * Created by Levon on 2/9/2016, 9:12 PM
 */
public class StartJetty {
    public static void main( String[] args ) throws Exception
    {
        //Web Server
        Server server = new Server();
        // HTTP connector
        ServerConnector http = new ServerConnector(server);
        http.setHost("0.0.0.0");
        http.setPort(8080);
        http.setIdleTimeout(90000);
        server.addConnector(http);

        //Web Socket
        Server socket = new Server();
        // WS connector
        ServerConnector ws = new ServerConnector(socket);
        ws.setHost("0.0.0.0");
        ws.setPort(1337);
        ws.setIdleTimeout(90000);
        socket.addConnector(ws);


        // Setup JMX
        MBeanContainer mbContainer = new MBeanContainer(
                ManagementFactory.getPlatformMBeanServer());
        server.addBean(mbContainer);

        //set up context path and WEB-INF directory
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        File warFile = new File(
                "out/artifacts/chess");
        webapp.setWar(warFile.getAbsolutePath());

        //add Web App to server
        server.setHandler(webapp);

        //create ws handler
        WebSocketHandler wsHandler = new WebSocketHandler() {
            @Override
            public void configure(WebSocketServletFactory factory) {
                factory.register(PlayChessSocket.class);
            }
        };
        //add ws handler to socket
        socket.setHandler(wsHandler);

        //add i rooms
        for(int i=0;i<5;i++){
            PlayChessSocket.rooms.add(new Room(PlayChessSocket.rooms.size(),null,null));
        }

        // Start server,socket
        server.start();
        socket.start();

        //Join
        server.join();
        socket.join();



    }
}
