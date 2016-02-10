package web.game;

import org.eclipse.jetty.websocket.api.Session;

/**
 * Created by Levon on 2/10/2016, 11:14 PM
 */
public class Room {
    private int id;
    private Session white;
    private Session black;

    public Room(int id,Session white, Session black) {
        this.id=id;
        this.white = white;
        this.black = black;
    }

    public Session getWhite() {
        return white;
    }

    public void setWhite(Session white) {
        this.white = white;
    }

    public Session getBlack() {
        return black;
    }

    public void setBlack(Session black) {
        this.black = black;
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
}
