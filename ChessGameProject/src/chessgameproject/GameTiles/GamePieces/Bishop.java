package chessgameproject.GameTiles.GamePieces;

import chessgameproject.GameBoard;
import chessgameproject.Player;
import chessgameproject.GameTiles.PlayerPieces;

public class Bishop extends PlayerPieces{ 
   
    public Bishop(String value, int x, int y, Player pieceColor){
        super(value,x,y, pieceColor);
    }
    
    @Override
    public boolean canMoveTo(int x, int y) {
        
        Boolean determine = true;

        if (!GameBoard.tt[x][y].getPieceColor().equals(pieceColor)) {
            
            int distanceX = Math.abs(this.x - x);
            int distanceY = Math.abs(this.y - y);
            
            // check if the coordinate is in a diagonal line
            if (distanceX != distanceY) {
                return false;
            } 
            
            determine = moveDiagonal(x, y, distanceX, distanceY);
            
            } else {
                return false;
            }
        
        return determine;
    }
    
     @Override
    public void moveTo(int x, int y) {
        
        switch (getPieceColor()) {
            case WHITE:
                GameBoard.tt[x][y] = new Bishop("wB", x, y, Player.WHITE);
                break;
            case BLACK:
                GameBoard.tt[x][y] = new Bishop("bB", x, y, Player.BLACK);
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
    
    public Boolean moveDiagonal(int x, int y, int distanceX, int distanceY) {
        
        Boolean determine = true;
        
        if (x < this.x) {
                if (y < this.y) {
                    
                    for (int i = 1; i < distanceX; i++) {
                        if (!(GameBoard.tt[this.x - i][this.y - i].getPieceColor().equals(Player.NONE))) {
          
                            determine = false;
                            break;
                        }
                    }
                } else {
                    
                    for (int i = 1; i < distanceX; i++) {
                        if (!(GameBoard.tt[this.x - i][this.y + i].getPieceColor().equals(Player.NONE))) {
                            
                            determine = false;
                            break;
                        }
                    }
                }
            } else if (x > this.x) {
                if (y < this.y) {
                    
                    for (int i = 1; i < distanceX; i++) {
                        if (!(GameBoard.tt[this.x + i][this.y - 1].getPieceColor().equals(Player.NONE))) {
                            determine = false;
                            break;
                        }
                    }
                } else {
                    
                    for (int i = 1; i < distanceX; i++) {
                        if (!(GameBoard.tt[this.x + i][this.y + i].getPieceColor().equals(Player.NONE))) {
                            determine = false;
                            break;
                        }
                    }
                }
            }
        
        return determine;
    }
}
