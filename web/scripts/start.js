/**
 * Created by Levon on 2/6/2016.
 */
var board;
var player="W";

$(document).ready(function() {

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