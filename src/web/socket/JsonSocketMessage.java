package web.socket;

/**
 * Created by levon.gevorgyan on 11/02/16.
 */
public class JsonSocketMessage {
    private String id;
    private String msg;

    public JsonSocketMessage(String id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }
    public String answerJSON(){
        return "{\"id\":\""+id+"\",\"msg\":\""+msg+"\"}";
    }
}
