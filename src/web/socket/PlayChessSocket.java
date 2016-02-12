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

    public static ArrayList<Room> rooms=new ArrayList<>();

    // called when the socket connection with the browser is established
    @OnWebSocketConnect
    public void handleConnect(Session session) {
        //this.session=session;
        WebMethods.roomsToJSON(rooms);
        send(new JsonSocketMessage("rooms",WebMethods.roomsToJSON(rooms)).answerJSONArray(), session);
        /*if(rooms.size()==0){
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
        }*/
    }

    // called when the connection closed
    @OnWebSocketClose
    public void handleClose(Session session,int statusCode, String reason) {
        System.out.println("close");
        String s=WebMethods.sessionToString(session);
        System.out.println(s);
        for (Room room:rooms){
            String w=WebMethods.sessionToString(room.getWhite());
            System.out.println(w);
            String b=WebMethods.sessionToString(room.getBlack());
            System.out.println(b);
            if (w.equals(s)) {
                System.out.println("white");
                room.setWhite(null);
                break;
            }
            if (b.equals(s)) {
                room.setBlack(null);
                break;
            }
        }
        for (Room x:rooms){
            System.out.println(x.toString());
        }
    }

    // called when a message received from the browser
    @OnWebSocketMessage
    public void handleMessage(Session session,String message) {
        JsonSocketMessage socketMessage=WebMethods.getJsonSocketMessage(message);
        switch (socketMessage.getId()){
            case "move":
                Room getSessionCurrentRoom= WebMethods.getCurrentRoom(session,rooms);
                System.out.println("Current room: "+getSessionCurrentRoom.toString());


                System.out.println("Socket: " + socketMessage.getMsg());

                send(socketMessage.answerJSON(), getSessionCurrentRoom.getWhite());
                send(socketMessage.answerJSON(), getSessionCurrentRoom.getBlack());
                break;
            case "room":
                System.out.println(Integer.parseInt(socketMessage.getMsg()));
                Room i=rooms.get(Integer.parseInt(socketMessage.getMsg()));
                if(i.getWhite()==null){
                    i.setWhite(session);
                    send(new JsonSocketMessage("room_count", String.valueOf(i.getCountOnlinePlayers())).answerJSON(), session);
                    send(new JsonSocketMessage("turn","W").answerJSON(),session);
                }else if(i.getBlack()==null) {
                    i.setBlack(session);
                    send(new JsonSocketMessage("room_count", String.valueOf(i.getCountOnlinePlayers())).answerJSON(), session);
                    send(new JsonSocketMessage("turn","B").answerJSON(),session);
                }else {
                    send(new JsonSocketMessage("room_count","Room is full").answerJSON(),session);
                }
                break;

        }
        for (Room x:rooms){
            System.out.println(x.toString());
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