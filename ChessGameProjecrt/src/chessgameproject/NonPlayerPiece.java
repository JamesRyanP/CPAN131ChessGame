package chessgameproject;

public class NonPlayerPiece extends Tile{

    public NonPlayerPiece(String value, Player pieceColor) {
        super(value, pieceColor);
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        return true;
    }

    @Override
    public void moveTo(int x, int y) {
        
    }
    
    
    
}
