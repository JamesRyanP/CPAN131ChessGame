package chessgameproject.GameTiles.GamePieces;

import chessgameproject.GameBoard;
import chessgameproject.Player;
import chessgameproject.GameTiles.PlayerPieces;

public class King extends PlayerPieces{


    
     public King (String value, int x, int y, Player pieceColor){
        super(value,x,y, pieceColor);
    }



    // No reason to have setter for pieceColor as it will never change // 
    
    
     @Override
    public boolean canMoveTo(int x, int y) {

        if (!GameBoard.tt[x][y].getPieceColor().equals(pieceColor)) {
            int distanceX = Math.abs(this.x - x);
            int distanceY = Math.abs(this.y - y);

            return distanceX == 1 && distanceY == 0
                    || distanceX == 0 && distanceY == 1
                    || distanceY == 1 && distanceX == 1;

        } else {
            return false;
        }
    }
    
     @Override
    public void moveTo(int x, int y) {
        
        switch (getPieceColor()) {
            case WHITE:
                GameBoard.tt[x][y] = new King("wK", x, y, Player.WHITE);
                break;
            case BLACK:
                GameBoard.tt[x][y] = new King("bK", x, y, Player.BLACK);
                break;
            default:
                break;
        }

        setNewCoordinates(x, y);
    }
    
    public void setNewCoordinates(int x, int y) {
        
        this.x = x;
        this.y = y;
    }
}
    
