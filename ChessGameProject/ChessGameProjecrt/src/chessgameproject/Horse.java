package chessgameproject;

public class Horse extends PlayerPieces{
        

     public Horse (String value, int x, int y, Player pieceColor){
        super(value,x,y, pieceColor);
    }


    // No reason to have setter for pieceColor as it will never change // 
    
    
    @Override
    public boolean canMoveTo(int x, int y){
        
     
        
        if(!GameBoard.tt[x][y].getPieceColor().equals(pieceColor) ){
            System.out.println("not same color");
        
        }
        
        else{
             System.out.println("same color");
        }
        
    return true;
    }
    
    @Override
    public void moveTo(int x, int y){
    
    }
}