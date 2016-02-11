/**
 * Created by levon.gevorgyan on 09/02/16.
 */
//socket functions
function msgToJson(id,msg){
    return '{"id":'+id+',"msg":"'+msg+'"}';
}
function msgToJsonArray(id,msg){
    return '{"id":"'+id+'","msg":"'+msg+'"}';
}
var my_room;
function room_click(i){
    my_room=i;
    console.log("clicked Room "+(i+1));
    console.log(msgToJsonArray('room',i));
    ws.send(msgToJsonArray("room",i));
}


//board functions
function cellItemImg(source){
    for(var i=0;i<64;i++){

        var x=$.parseJSON(board);

        if(x.board[i].cell===source){
            /*console.log(source);
            console.log(x.board[i].cell);*/
            return x.board[i].img;
        }
    };
}
