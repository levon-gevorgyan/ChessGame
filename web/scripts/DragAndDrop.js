/**
 * Created by Levon on 2/6/2016.
 */

function dragStart(ev) {
    ev.dataTransfer.effectAllowed='move';

    ev.dataTransfer.setData("Text", ev.target.getAttribute('id'));
    //Source=ev.target.getAttribute('id');

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
    if($('#'+ev.dataTransfer.getData("Text")).attr('draggable')=='true'){
        console.log(ev.dataTransfer.getData("Text"));
        $('#'+ev.target.getAttribute('id')).attr("src","images/items/BlackRook.png");
        $('#'+ev.dataTransfer.getData("Text")).attr("src","images/items/Empty.png");

    }
    ev.stopPropagation();
    return false;
}