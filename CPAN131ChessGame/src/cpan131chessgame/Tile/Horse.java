
package cpan131chessgame.Tile;

import cpan131chessgame.Player;

public class Horse extends Tile{
        
    // pieceColor is enum for either "BLACK" or "WHITE"
    protected final Player pieceColor;

    
    public Horse(String value, Player pieceColor){
        super(value);
        this.pieceColor = pieceColor;

    }

    public Player getPieceColor() {
        return pieceColor;
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
