package web.game;

import org.eclipse.jetty.websocket.api.Session;
import web.WebMethods;

/**
 * Created by Levon on 2/10/2016, 11:14 PM
 */
public class Room{
    private int id;
    private Session white;
    private Session black;
    private int countOnlinePlayers =0;

    public Room(int id,Session white, Session black) {
        this.id=id;
        this.white = white;
        this.black = black;
        if(white!=null){
            countOnlinePlayers++;
        }
        if(black!=null){
            countOnlinePlayers++;
        }
    }
    public void leftRoom(Session session){
        if(WebMethods.sessionToString(session).equals(WebMethods.sessionToString(this.white))){
            this.white=null;
            countOnlinePlayers--;
        }
        if(WebMethods.sessionToString(session).equals(WebMethods.sessionToString(this.black))){
            this.black=null;
            countOnlinePlayers--;
        }
    }

    public Session getWhite() {
        return white;
    }

    public void setWhite(Session white) {
        if(this.white==null){
            this.white = white;
            countOnlinePlayers++;
        }else {
            this.white = white;
        }
    }

    public Session getBlack() {
        return black;
    }

    public void setBlack(Session black) {
        if(this.black==null){
            this.black = black;
            countOnlinePlayers++;
        }else {
            this.black = black;
        }
    }
    public String toString(){

        if(white==null && black==null) {
            return  "Room " + id + " has no Hosts";
        }
        String s="Room "+id+": \n";
        if(white!=null){
            s+="W: "+white.getRemoteAddress().getHostName()+":"+white.getRemoteAddress().getPort()+"\n";
        }
        if(black!=null){
            s+="B: "+black.getRemoteAddress().getHostName()+":"+black.getRemoteAddress().getPort()+"\n";
        }

        return s;
    }

    public int getCountOnlinePlayers() {
        return countOnlinePlayers;
    }


}
