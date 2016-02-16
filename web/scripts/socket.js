/**
 * Created by levon.gevorgyan on 10/02/16.
 */
var ws;
var allRooms;
/*var mate;
var check;*/
var castling_done_w="false";
var castling_done_b="false";
/*if(myip=="37.157.220.37") {
 ws = new WebSocket("ws://192.168.1.100:1337/");
 }else{
 ws = new WebSocket("ws://100.82.31.187:1337/");
 }*/
var me;
ws = new WebSocket("ws://it-pc:1337/");
//ws.onopen;

ws.onmessage = function (evt) {
    console.log(evt.data);

    var anwser = $.parseJSON(evt.data);
    //console.log(anwser[0].id)

    switch (anwser.id){
        case "check":
            alert(anwser.msg);
            break;
        case "mate":
            alert(anwser.msg);
            break;
        case "move":
            var move=anwser.msg;


            src=move.substring(0,2);
            trg=move.substring(2,4);
            $('.white-cell').css("border","solid thin black");
            $('.black-cell').css("border","solid thin black");


            //ev.target.appendChild(document.getElementById(src));
            //Target=ev.target.getAttribute('id');
            //if ($('#' + src).attr('draggable') == 'true') {
                console.log(src);
                $('#' + trg).attr("src", cellItemImg(src));
                $('#' + src).attr("src", "images/items/Empty.png");

            //}
            $.get("drop", {
                board: board,
                move: src + trg,
                turn: player,
                castling_done_w: castling_done_w,
                castling_done_b: castling_done_b
            }, function (response) {
                board = response;
                var parsedBoard=JSON.parse(board)
                console.log(parsedBoard.status[0].mate);
                if(parsedBoard.status[0].mate!="false"){
                    var mate=parsedBoard.status[0].mate;
                    console.log(mate);
                    if(mate==="white" || mate==="black"){
                        if(player===me){
                            ws.send(msgToJson("mate",mate));

                        }
                    }
                }
                if(parsedBoard.status[0].check!="false"){
                    var check=parsedBoard.status[0].check;
                    console.log("check"+check);
                    if(check==="white" || check==="black"){
                        if(player===me){
                            ws.send(msgToJson("check",check));

                        }
                    }
                }
                $('#' + src).attr('draggable', 'false');
                $('#' + trg).attr('draggable', 'false');
                $('#' + src).attr("ondragstart", "");
                $('#' + trg).attr("ondragstart", "");
            });
            $('#last_move').html(src+'->'+trg);


            if (player === "W") {
                player = "B";
            } else {
                player = "W";
            }
            console.log(player);
            if(player==="W") {
                $('#turn').html("White Army Turn");
            }
            if(player==="B") {
                $('#turn').html("Black Army Turn");
            }
            $.get("turn", {
                chessboard: board,
                player: player
            }, function (response) {
                var activeCells = $.parseJSON(response);
                $('.cell').attr("draggable", "false");
                $('.cell').attr("ondragstart", "");
                $('.cell').css("cursor", "");

                console.log("me: "+me);
                console.log("turn: "+player);
                if(player==me) {
                    for (var i = 0; i < activeCells.length; i++) {
                        $('#' + activeCells[i]).attr("draggable", "true");
                        $('#' + activeCells[i]).attr("ondragstart", "return dragStart(event)");
                        $('#' + activeCells[i]).css("cursor", "pointer");
                    }
                }
            });
            break;
        case "turn":
            me=anwser.msg;
            console.log(me);
            break;
        case "rooms":
            console.log(anwser.msg);
            var rooms= anwser.msg;
            allRooms=rooms;
            for(var i=0;i<rooms.length;i++){
                console.log(rooms[i]);
                $('#rooms').append('<div class=room id="r'+i+'" onclick="room_click('+i+')" class=room>Room '+(i)+': '+rooms[i]+'/2');

            }
            break;
        case "all_rooms":
            console.log(anwser.msg);
            var rooms= anwser.msg;
            allRooms=rooms;
            for(var i=0;i<rooms.length;i++){
                console.log(rooms[i]);
                $('#r'+i).html('Room '+(i)+': '+rooms[i]+'/2');
            }
            break;
        case "room_count":
            var count=anwser.msg;
            if(anwser.msg!=="Room is full") {
                $('#left_room').show();
                $('#joined_room').show();
                $('#rooms').hide();
                $('#room_label').hide();

                for (var i = 0; i < allRooms.length; i++) {
                    if (i === my_room) {
                        $('#joined_room_number').html('Joined Room '+i);
                        break;
                    }
                }
            }
            else{
                alert("Room is full");
            }
            break;
        case "start":
            $.get( "start", {
                room:my_room
            }, function( response ) {
                board= $.parseJSON(response);
                //console.log(board);
                for(var i=0;i<64;i++){
                    $('#'+board.board[i].cell).attr("src",board.board[i].img);
                };
                mate=board.status[0].mate;
                check=board.status[0].check;
                console.log(mate);
                console.log(check);

                board=JSON.stringify(board);
                //console.log(board);
                //$('#start').hide();
                $.get("turn", {
                    chessboard: board,
                    player: player
                }, function (response) {
                    var activeCells = $.parseJSON(response);
                    $('.cell').attr("draggable", "false");
                    $('.cell').attr("ondragstart", "");
                    $('.cell').css("cursor", "");

                    console.log("me: "+me);
                    console.log("turn: "+player);
                    if(player==me) {
                        for (var i = 0; i < activeCells.length; i++) {

                            $('#' + activeCells[i]).attr("draggable", "true");
                            $('#' + activeCells[i]).attr("ondragstart", "return dragStart(event)");
                            $('#' + activeCells[i]).css("cursor", "pointer");
                        }
                    }
                });

            });
            if(me==="W"){
                $('#player').html("You control white items");
            }
            if(me==="B"){
                $('#player').html("You control black items");
            }
            $('#turn').show();
            if(player==="W") {
                $('#turn').html("White Army Turn");
            }
            if(player==="B") {
                $('#turn').html("Black Army Turn");
            }

            break;
        case "opp_left":
            alert("Your opponent has just left the game. I think you are the winner :)");
            leftRoom();
            break;



    }
};