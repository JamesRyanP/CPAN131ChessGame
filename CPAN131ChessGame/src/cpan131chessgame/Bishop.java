
package cpan131chessgame;

public class Bishop extends Tile{ 
    
    // pieceColor is enum for either "BLACK" or "WHITE"
    protected final Player pieceColor;
    protected int currentX;
    protected int currentY;
    
    public Bishop(String value, Player pieceColor, int X, int Y){
        super(value);
        this.pieceColor = pieceColor;
        currentX = X;
        currentY = Y;
    }

    public Player getPieceColor() {
        return pieceColor;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    // No reason to have setter for pieceColor as it will never change // 
    
    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }
    
    
    @Override
    public boolean canMoveTo(int x, int y){
    return true;
    }
    
    @Override
    public void moveTo(int x, int y){
    
    }
}
