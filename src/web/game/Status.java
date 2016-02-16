package web.game;

/**
 * Created by levon.gevorgyan on 16/02/16.
 */
public class Status {
    private String turn;
    private String mate="false";
    private String check="false";
    private String checkOpen="false";
    private String castlingDoneW;
    private String castlingDoneB;
    private String changePawn ="false";

    public String toJson(){
        return "],\"status\":[{" +
                "\"turn\":\""+this.turn+"\"," +
                "\"mate\":\""+this.mate+"\"," +
                "\"check\":\""+this.check+"\"," +
                "\"check_open\":\""+this.checkOpen+"\",\"" +
                "castling_done_w\":\""+this.castlingDoneW+"\"," +
                "\"castling_done_b\":\""+this.castlingDoneB+"\"," +
                "\"change_pawn\":\""+this.changePawn+"\"}]}";
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public Status(String turn,String castlingDoneW,String castlingDoneB) {
        this.turn=turn;
        this.castlingDoneW=castlingDoneW;
        this.castlingDoneB=castlingDoneB;
    }

    public String getMate() {
        return mate;
    }

    public void setMate(String mate) {
        this.mate = mate;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public String getCheckOpen() {
        return checkOpen;
    }

    public void setCheckOpen(String checkOpen) {
        this.checkOpen = checkOpen;
    }

    public String getCastlingDoneW() {
        return castlingDoneW;
    }

    public void setCastlingDoneW(String castlingDoneW) {
        this.castlingDoneW = castlingDoneW;
    }

    public String getCastlingDoneB() {
        return castlingDoneB;
    }

    public void setCastlingDoneB(String castlingDoneB) {
        this.castlingDoneB = castlingDoneB;
    }

    public String getChangePawn() {
        return changePawn;
    }

    public void setChangePawn(String changePawn) {
        this.changePawn = changePawn;
    }
}
