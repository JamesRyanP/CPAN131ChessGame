package chessgameproject;

public class PlayerPieces extends Tile{
    protected int x;
    protected int y;
    
    public PlayerPieces(String value, int x, int y, Player pieceColor) {
        super(value, pieceColor);
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        return true;
    }

    @Override
    public void moveTo(int x, int y) {
   
    }
    
    
}
