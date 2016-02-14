package web.socket;

import org.json.JSONArray;

/**
 * Created by levon.gevorgyan on 11/02/16.
 */
public class JsonSocketMessage {
    private String id;
    private String msg;
    private JSONArray msgArray;

    public JsonSocketMessage(String id, String msg) {
        this.id = id;
        this.msg = msg;
    }
    public JsonSocketMessage(String id, JSONArray msgArray) {
        this.id = id;
        this.msgArray = msgArray;
    }

    public JSONArray getMsgArray() {
        return msgArray;
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
    public String answerJSONArray(){
        return "{\"id\":\""+id+"\",\"msg\":"+msg+"}";
    }
}
