public class Board {
    private Tas[][] board = new Tas[3][3] ;

    public Board(){
        for(int i = 0 ; i< board.length;i++){
            for(int j = 0 ; j<board.length;j++){
                board[i][j] = new Tas(i,j);
            }
        }
    }
    
    public Tas[][] getBoard(){
        return this.board ; 
    }


    public void setLocationtoTas(int i , int j, int turn){
        if(turn ==1)
            this.board[i][j].setFlag("X");
        else 
            this.board[i][j].setFlag("O");
    }

}
