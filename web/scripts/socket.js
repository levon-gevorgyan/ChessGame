/**
 * Created by levon.gevorgyan on 10/02/16.
 */
var ws;
if(myip=="37.157.220.37") {
 ws = new WebSocket("ws://192.168.1.100:1337/");
 }else{
 ws = new WebSocket("ws://100.82.31.187:1337/");
 }

//ws = new WebSocket("ws://it-pc:1337/");
//ws.onopen;
ws.onmessage = function (evt) {
    move = evt.data;
    console.log(move);
    src=move.substring(0,2);
    trg=move.substring(2,4);
    $('.white-cell').css("border","solid thin black");
    $('.black-cell').css("border","solid thin black");


    //ev.target.appendChild(document.getElementById(src));
    //Target=ev.target.getAttribute('id');
    if ($('#' + src).attr('draggable') == 'true') {
        console.log(src);
        $('#' + trg).attr("src", cellItemImg(src));
        $('#' + src).attr("src", "images/items/Empty.png");

    }
    $.get("drop", {
        board: board,
        move: src + trg,
        turn: player
    }, function (response) {
        board = response;
        $('#' + src).attr('draggable', 'false');
        $('#' + trg).attr('draggable', 'false');
        $('#' + src).attr("ondragstart", "");
        $('#' + trg).attr("ondragstart", "");
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

    });
};