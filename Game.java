import java.util.Scanner;

public class Game {

    Board board = new Board();
    Player p1,p2 ;
    Scanner sc = new Scanner(System.in);
    public Game(){
        board = new Board();
        //System.out.println(board.getBoard().length);
       
    }

    public void run(){
        System.out.println("Oyun baslatiliyor. ");
        System.out.println("oyuncu 1 : X , oyuncu 2 : O tasini almaktadir.");
        int sayac = 1 ;
        
        while(!isGameOver()){
            printBoard();
            System.out.println("Sira Oyuncu " + sayac + " : ");
            int locX,locY ;
            do {
                System.out.println("Tasi Koymak istediginiz lokasyonu belirtiniz : Exs : 0,1 ,  1,2  ,  1,1  : ");
                String messageFromPlayer = sc.nextLine() ;
                locX = Integer.parseInt(messageFromPlayer.substring(0,1)) - 1;
                locY = Integer.parseInt(messageFromPlayer.substring(2)) - 1  ;
                if(!checkIfLocationEmpty(locX,locY)){
                    System.out.println("Orasi dolu la gormuyon mu ? Bir daha yer sec : ");
                }     
            } while( !checkIfLocationEmpty(locX, locY) );

            board.setLocationtoTas(locX,locY,sayac);
           
            if(sayac ==1)
                sayac ++ ;
            else
                sayac = 1 ;
            
        }
    }

    private void printBoard() {
        for(int i = 0 ; i< board.getBoard().length;i++){
            for(int j = 0 ; j<board.getBoard().length;j++){
                System.out.print( board.getBoard()[i][j].toString() + "\t");
            }
            for(int j = 0 ; j < 6 ; j++)
                System.out.println();
        }
    }

    public boolean checkIfLocationEmpty(int i , int j){
        if(board.getBoard()[i][j].getFlag().equals("Bos")){
            return true ;
        }
        return false ;
    }

    public boolean isGameOver(){
        if(checkIfLineX() ||  checkICrossX()){
            printBoard();
            System.out.println("Oyuncu 1 kazandi !");
            return true ;
        }  
        else if(checkIfLineO() || checkIfCrossO()){
            printBoard();
            System.out.println("Oyuncu 2 kazandi !");
            return true ;
        }  
        return false ;
    }
    private boolean checkIfLineX(){
        for(int i = 0 ; i< board.getBoard().length;i++){
            
            if( (board.getBoard()[i][0].getFlag().equals("X"))  && (board.getBoard()[i][1].getFlag().equals("X") && (board.getBoard()[i][2].getFlag().equals("X")))){
                return true;
            }
            else if ( (board.getBoard()[0][i].getFlag().equals("X"))  && (board.getBoard()[1][i].getFlag().equals("X") && (board.getBoard()[2][i].getFlag().equals("X")))){
                return true ;
            }
        }
        return false ;
    }
    private boolean checkIfLineO(){
        for(int i = 0 ; i< board.getBoard().length;i++){
            
            if( (board.getBoard()[i][0].getFlag().equals("O"))  && (board.getBoard()[i][1].getFlag().equals("O") && (board.getBoard()[i][2].getFlag().equals("O")))){
                return true;
            }
            else if ( (board.getBoard()[0][i].getFlag().equals("O"))  && (board.getBoard()[1][i].getFlag().equals("O") && (board.getBoard()[2][i].getFlag().equals("O")))){
                return true ;
            }
        }
        return false ;
    }



    private boolean checkICrossX(){
        if( (board.getBoard()[0][0].getFlag().equals("X")) && (board.getBoard()[1][1].getFlag().equals("X")) && (board.getBoard()[2][2].getFlag().equals("X")) ){
            return true ;
        }
        else if ( (board.getBoard()[0][2].getFlag().equals("X")) && (board.getBoard()[1][1].getFlag().equals("X")) && (board.getBoard()[2][0].getFlag().equals("X"))){
            return true ;
        }
        return false ;
    }

    private boolean checkIfCrossO(){
        if( (board.getBoard()[0][0].getFlag().equals("O")) && (board.getBoard()[1][1].getFlag().equals("O")) && (board.getBoard()[2][2].getFlag().equals("O")) ){
            return true ;
        }
        else if ( (board.getBoard()[0][2].getFlag().equals("O")) && (board.getBoard()[1][1].getFlag().equals("O")) && (board.getBoard()[2][0].getFlag().equals("O"))){
            return true ;
        }
        return false ;
    }



}
