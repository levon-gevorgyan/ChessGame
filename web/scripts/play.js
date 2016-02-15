/**
 * Created by Levon on 2/6/2016.
 */
var board;
var player="W"; //which player's turn
console.log(player);

$(document).ready(function() {
    $('#left_room').hide();
    $('#joined_room').hide();
    $('#left_room').click(function(){
        if(confirm("Do you want left the game")) {
            alert("You left the game");
            leftRoom();
        }

    });
});

function leftRoom() {
    ws.send(msgToJsonArray2("left_room", '"' + my_room + '","' + me + '"'));
    $('#rooms').show();
    $('#room_label').show();
    $('#left_room').hide();
    $('#joined_room').hide();
    $('#turn').html('');
    $('#turn').hide('');

    if (board !== null) {
        $('.cell').attr("draggable", "false");
        $('.cell').attr("ondragstart", "");
        $('.cell').attr("ondragenter", "");
        $('.cell').attr("ondrop", "");
        $('.cell').attr("ondragover", "");
        $('.cell').attr("src", "");
        $('#player').html("");
        board = null;
        player = "W";
        me = null;
        my_room = null;

    }
}