/**
 * Created by Levon on 2/6/2016.
 */
$(document).ready(function() {

    $('#start').click(function(){

        var board;

        $.get( "start", {

        }, function( response ) {
            board= $.parseJSON(response)
            console.log(board);
            for(var i=0;i<64;i++){
                $('#'+board[i].cell).attr("src",board[i].img);
            };
            board=JSON.stringify(board);
            console.log(board);
            $('#start').hide();

        });

    });
  /*  $('#userName').blur(function() {
        $.ajax({
            url : 'GetUserServlet',

            data : {
                userName : $('#userName').val()
            },
            success : function(responseText) {
                $('#ajaxGetUserServletResponse').text(responseText);
            }
        });
    });*/
});