package chessgameproject;

public class Rook extends PlayerPieces{


    
     public Rook (String value, int x, int y, Player pieceColor){
        super(value,x,y, pieceColor);
    }


    // No reason to have setter for pieceColor as it will never change // 
    
    
    @Override
    public boolean canMoveTo(int x, int y){
    return true;
    }
    
    @Override
    public void moveTo(int x, int y){
    
    }
    
}