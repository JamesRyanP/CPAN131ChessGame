package chessgameproject.GameTiles.EmptyTile;

import chessgameproject.GameTiles.Tile;
import chessgameproject.Player;

public class EmptyTile extends Tile{

    public EmptyTile(String value, Player pieceColor) {
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
