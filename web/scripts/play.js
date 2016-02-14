/**
 * Created by Levon on 2/6/2016.
 */
var board;
var player="W";
console.log(player);

$(document).ready(function() {
    $('#left_room').hide();
    $('#joined_room').hide();
    $('#left_room').click(function(){
        ws.send(msgToJson("left_room",my_room));
        $('#rooms').show();
        $('#left_room').hide();
        $('#joined_room').hide();

    });


    $('#start').click(function(){



        $.get( "start", {

        }, function( response ) {
            board= $.parseJSON(response);
            //console.log(board);
            for(var i=0;i<64;i++){
                $('#'+board.board[i].cell).attr("src",board.board[i].img);
            };
            board=JSON.stringify(board);
            //console.log(board);
            $('#start').hide();
            $.get("turn",{
                chessboard:board,
                player:player
            },function(response){
                var activeCells= $.parseJSON(response);


                    for(var i=0;i<activeCells.length;i++){
                        $('#'+activeCells[i]).attr("draggable","true");
                        $('#'+activeCells[i]).attr("ondragstart","return dragStart(event)");
                    }

            });

        });

    });


});