package web.socket;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;
import web.WebMethods;
import web.game.Room;

import java.io.IOException;
import java.util.*;


/**
 * Created by levon.gevorgyan on 10/02/16.
 */
@WebSocket
public class PlayChessSocket {

    private static ArrayList<Room> rooms=new ArrayList<>();

    // called when the socket connection with the browser is established
    @OnWebSocketConnect
    public void handleConnect(Session session) {
        //this.session=session;
        if(rooms.size()==0){
            Room room=new Room(rooms.size()+1,session,null);
            send(new JsonSocketMessage("turn","W").answerJSON(),session);
            rooms.add(room);
        }
        else if(rooms.get(rooms.size()-1).getWhite()!=null && rooms.get(rooms.size()-1).getBlack()==null){
            rooms.get(rooms.size()-1).setBlack(session);
            send(new JsonSocketMessage("turn","B").answerJSON(),session);
        }
        else {
            Room room=new Room(rooms.size()+1,session,null);
            send(new JsonSocketMessage("turn","W").answerJSON(),session);
            rooms.add(room);
        }
        for (Room x:rooms){
            System.out.println(x.toString());
        }
    }

    // called when the connection closed
    @OnWebSocketClose
    public void handleClose(int statusCode, String reason) {

    }

    // called when a message received from the browser
    @OnWebSocketMessage
    public void handleMessage(Session session,String message) {
        JsonSocketMessage socketMessage=WebMethods.getJsonSocketMessage(message);
        for (Room x:rooms){
            System.out.println(x.toString());
        }
        switch (socketMessage.getId()){
            case "move":
                Room getSessionCurrentRoom= WebMethods.getCurrentRoom(session,rooms);
                System.out.println("Current room: "+getSessionCurrentRoom.toString());


                System.out.println("Socket: " + socketMessage.getMsg());

                send(socketMessage.answerJSON(), getSessionCurrentRoom.getWhite());
                send(socketMessage.answerJSON(), getSessionCurrentRoom.getBlack());
                break;
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