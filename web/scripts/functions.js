/**
 * Created by levon.gevorgyan on 09/02/16.
 */
function cellItemImg(source){
    for(var i=0;i<64;i++){

        var x=$.parseJSON(board);

        if(x.board[i].cell===source){
            /*console.log(source);
            console.log(x.board[i].cell);*/
            return x.board[i].img;
        }
    };
}
