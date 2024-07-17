public class Tas {
    private int player ;
    private String flag ;
    private int locationX ;
    private int locationY ;


    public Tas(int i, int j){
        player = 0 ;
        flag = "Bos" ;
        locationX = i ;
        locationY = j ;
    }
    public void setPlayer(int newPlayer){
        this.player = newPlayer ;
    }
    public void setFlag(String newFlag){
        this.flag = newFlag;
    }
    public void setLocationX(int newLocationX){
        this.locationX = newLocationX ;
    }
    public void setLocationY(int newLocationY){
        this.locationY = newLocationY ;
    }

    public int getPlayer(){
        return player;
    }
    public String getFlag(){
        return flag ;
    }
    public int getLocationX(){
        return locationX ;
    }
    public int getLocationY(){
        return locationY ;
    }
    
    @Override
    public String toString(){
        if(this.flag.equals("O")){
            return "O" ;
        }
        else if(this.flag.equals("X")){
            return "X" ;
        }
        else {
            return "-" ;
        }
    }
}
