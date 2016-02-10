package web.socket;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by levon.gevorgyan on 10/02/16.
 */
@WebSocket
public class PlayChessSocket {
    static ScheduledExecutorService timer =
            Executors.newSingleThreadScheduledExecutor();

    private static SortedMap<String,Session> allSessions=new TreeMap<>();


    /*public static ArrayList<Session> allSessions;
    DateTimeFormatter timeFormatter =
            DateTimeFormatter.ofPattern("HH:mm:ss");
    private String s=String.valueOf(Math.random());

    private Session session;*/
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    // called when the socket connection with the browser is established
    @OnWebSocketConnect
    public void handleConnect(Session session) {
        //this.session=session;
        allSessions.put(session.getRemoteAddress().getHostString()+":"+session.getRemoteAddress().getPort(), session);
        for(SortedMap.Entry<String,Session> pair:allSessions.entrySet()){
            System.out.println(pair.getValue().getRemoteAddress().getAddress()+":"+pair.getValue().getRemoteAddress().getPort());
        }
    }

    // called when the connection closed
    @OnWebSocketClose
    public void handleClose(int statusCode, String reason) {
        for(SortedMap.Entry<String,Session> pair:allSessions.entrySet()){
            //System.out.println(pair.getValue().getRemoteAddress());
        }

        /*System.out.println("Connection closed with statusCode="
                + statusCode + ", reason=" + reason);*/
    }

    // called when a message received from the browser

    @OnWebSocketMessage
    public void handleMessage(String message) {
        System.out.println("Socket: "+message);
        for(SortedMap.Entry<String,Session> pair:allSessions.entrySet()){
            //System.out.println(message+""+pair.getValue().getRemoteAddress());
            send(message,pair.getValue());

        }
    }


    // called in case of an error
    @OnWebSocketError
    public void handleError(Throwable error) {
        error.printStackTrace();
    }

    // sends message to browser
    private void send(String message,Session session) {
        try {
            if (session.isOpen()) {
                session.getRemote().sendString(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // closes the socket
    private void stop(Session session) {
        try {
            session.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}