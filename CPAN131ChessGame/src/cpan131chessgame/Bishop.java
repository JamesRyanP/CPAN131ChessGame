
package cpan131chessgame;

public class Bishop extends Tile{ 
    
    // pieceColor is enum for either "BLACK" or "WHITE"
    Player pieceColor;
    
    public Bishop(String value, Player pieceColor){
        super(value);
        this.pieceColor = pieceColor;
    }
    
    
    @Override
    public boolean canMoveTo(int x, int y){
    return true;
    }
    
    @Override
    public void moveTo(int x, int y){
    
    }
}
