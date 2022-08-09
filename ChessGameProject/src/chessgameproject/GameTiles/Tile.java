package chessgameproject.GameTiles;

import chessgameproject.Player;

 abstract public class Tile {
    protected String value;
    protected final Player pieceColor;
    
    protected Tile (String value, Player pieceColor){
        this.value = value;
        this.pieceColor = pieceColor;
    }
    public String getValue(){
        return value;
    }
    
    public Player getPieceColor() {
        return pieceColor;
    }
    
    public void setValue(String value){
        this.value = value;
    }
    abstract public boolean canMoveTo(int x, int y);
    abstract public void moveTo(int x, int y);
}
