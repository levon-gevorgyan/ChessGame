/**
 * Created by Levon on 2/6/2016.
 */

//$(document).ready(function() {



    function dragStart(ev) {

        ev.dataTransfer.effectAllowed = 'move';
        var availableCells;

        ev.dataTransfer.setData("Text", ev.target.getAttribute('id'));

            $('.cell').attr("ondragenter","");
            $('.cell').attr("ondrop","");
            $('.cell').attr("ondragover","");
            $('.white-cell').css("border","solid thin black");
            $('.black-cell').css("border","solid thin black");

        $.get("on-drag-start", {
            board: board,
            src:ev.target.getAttribute('id')
        }, function (response) {
            availableCells= $.parseJSON(response);

            if(availableCells.length===0){

                $('#myMove').html("has no moves");

            }else{
                for(var i=0;i<availableCells.length;i++){
                    $('#'+availableCells[i]).attr("ondragenter","return dragEnter(event)");
                    $('#'+availableCells[i]).attr("ondrop","return dragDrop(event)");
                    $('#'+availableCells[i]).attr("ondragover","return dragOver(event)");
                    $('#c_'+availableCells[i]).css("border","solid thin yellow");
                }
                $('#myMove').html(availableCells);
                console.log(availableCells);
            }


        });


        //ev.dataTransfer.setDragImage(ev.target,0,0);

        return true;
    }

    function dragEnter(ev) {
        event.preventDefault();
        $.get("turn",{
            chessboard:board,
            player:player
        },function(response){
            var activeCells= $.parseJSON(response);
            $('.cell').attr("draggable","false");
            $('.cell').attr("ondragstart","");

            for(var i=0;i<activeCells.length;i++){

                $('#'+activeCells[i]).attr("draggable","true");
                $('#'+activeCells[i]).attr("ondragstart","return dragStart(event)");
            }

        });
        return true;
    }

    function dragOver(ev) {
        return false;
    }

    function dragDrop(ev) {
        var src=ev.dataTransfer.getData("Text");
        var trg=ev.target.getAttribute('id');
        var move=src+trg;
        console.log(move);
        $('.white-cell').css("border","solid thin black");
        $('.black-cell').css("border","solid thin black");
        ws.send(msgToJson("move",move));
        /*ws.onmessage = function (evt) {
            move = evt.data;
            src=move.substring(0,2);
            trg=move.substring(2,4);*/


            //ev.target.appendChild(document.getElementById(src));
            //Target=ev.target.getAttribute('id');
            /*if ($('#' + src).attr('draggable') == 'true') {
                console.log(src);
                $('#' + trg).attr("src", cellItemImg(src));
                $('#' + src).attr("src", "images/items/Empty.png");
            }
        console.log(player);
            $.get("drop", {
                board: board,
                move: src + trg,
                turn: player
            }, function (response) {
                board = response;
                $('#' + src).attr('draggable', 'false');
                $('#' + trg).attr('draggable', 'true');
                $('#' + src).attr("ondragstart", "");
                $('#' + trg).attr("ondragstart", "return dragStart(event)");
            });

            if (player === "W") {
                player = "B";
            } else {
                player = "W";
            }
        console.log(player);
            $.get("turn", {
                chessboard: board,
                player: player
            }, function (response) {
                var activeCells = $.parseJSON(response);
                $('.cell').attr("draggable", "false");
                $('.cell').attr("ondragstart", "");

                for (var i = 0; i < activeCells.length; i++) {

                    $('#' + activeCells[i]).attr("draggable", "true");
                    $('#' + activeCells[i]).attr("ondragstart", "return dragStart(event)");
                }

            });*/
        ev.stopPropagation();
        /*};*/
        return false;
    }
//});