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

        $.get("on-drag-start", {
            board: board,
            src:ev.target.getAttribute('id')
        }, function (response) {
            availableCells= $.parseJSON(response);
            if(availableCells.length===0){
                alert("has no moves");

            }else{
                for(var i=0;i<availableCells.length;i++){
                    $('#'+availableCells[i]).attr("ondragenter","return dragEnter(event)");
                    $('#'+availableCells[i]).attr("ondrop","return dragDrop(event)");
                    $('#'+availableCells[i]).attr("ondragover","return dragOver(event)");
                }
                console.log(availableCells);
            }

        });

        //ev.dataTransfer.setDragImage(ev.target,0,0);

        return true;
    }

    function dragEnter(ev) {
        event.preventDefault();
        return true;
    }

    function dragOver(ev) {
        return false;
    }

    function dragDrop(ev) {

        //ev.target.appendChild(document.getElementById(src));
        //Target=ev.target.getAttribute('id');
        if ($('#' + ev.dataTransfer.getData("Text")).attr('draggable') == 'true') {
            console.log(ev.dataTransfer.getData("Text"));
            $('#' + ev.target.getAttribute('id')).attr("src", "images/items/BlackRook.png");
            $('#' + ev.dataTransfer.getData("Text")).attr("src", "images/items/Empty.png");

        }
        ev.stopPropagation();
        return false;
    }
//});