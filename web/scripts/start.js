/**
 * Created by Levon on 2/6/2016.
 */
$(document).ready(function() {
    $('#start').click(function(){
        var allCells=[];
        var responseCells;
        $(".cell").each(function(){
            allCells.push($(this).attr('id'));
        });
        //console.log(allCells);
        $.get( "test-cells", {
            cells: allCells
        }, function( resp ) {
            responseCells= $.parseJSON(resp)
            console.log(responseCells);
            for(var i=0;i<64;i++){
                $('#'+allCells[i]).attr("src",responseCells[allCells[i]]);
            };
        });

        $('#a8').attr("src",responseCells);


        /*$.ajax({
            url:"test-cells",
            type:"GET",
            //dataType:'json',
            data: {cells:$cells},
            /!*success:function(data){
                // codes....
            },*!/


        });*/
        /*$.ajax({
            url : 'TestCells',
            data : {
                cells : $cells
            },
            type: "GET"/!*,
            success : function(responseText) {
                $('#ajaxGetUserServletResponse').text(responseText);
            }*!/
        })*/
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