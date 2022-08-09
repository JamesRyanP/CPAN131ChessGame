package chessgameproject.GameTiles.GamePieces;

import chessgameproject.GameBoard;
import chessgameproject.Player;
import chessgameproject.GameTiles.PlayerPieces;

public class Queen extends PlayerPieces{
    
     public Queen (String value, int x, int y, Player pieceColor){
        super(value,x,y, pieceColor);
    }

    public boolean canMoveTo(int x, int y) {

        Boolean determine = true;

        if (!GameBoard.tt[x][y].getPieceColor().equals(pieceColor)) {

            int distanceXStraight = (this.x - x);
            int distanceYStraight = (this.y - y);

            int distanceXDiagonal = Math.abs(this.x - x);
            int distanceYDiagonal = Math.abs(this.y - y);

            // check if the coordinate is a straight line
            if (distanceXDiagonal != 0 && distanceYDiagonal != 0) {
                if (distanceXDiagonal != distanceYDiagonal) {
                    return false;
                }
            }

            if (distanceXStraight == 0 && distanceYStraight != 0 || distanceXStraight != 0 && distanceYStraight == 0) {
                determine = moveStraight(x, y, distanceXStraight, distanceYStraight);
            } else if (distanceXDiagonal == distanceYDiagonal) {
                determine = moveDiagonal(x, y, distanceXDiagonal, distanceYDiagonal);
            }

        } else {
            return false;
        }

        return determine;
    }
    
    @Override
    public void moveTo(int x, int y) {
        
        switch (getPieceColor()) {
            case WHITE:
                GameBoard.tt[x][y] = new Queen("wQ", x, y, Player.WHITE);
                break;
            case BLACK:
                GameBoard.tt[x][y] = new Queen("bQ", x, y, Player.BLACK);
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
    
    public Boolean moveStraight(int x, int y, int distanceX, int distanceY) {

        Boolean determine = true;

        if (distanceX != 0) {

            // movement of 1 space does not need to be checked for pathways
            if (distanceX == 1 || distanceX == -1) {
                return true;
            }

            if (distanceX < 0) {

                for (int i = 1; i < Math.abs(distanceX); i++) {

                    if (!(GameBoard.tt[this.x + i][this.y].getPieceColor().equals(Player.NONE))) {
                        determine = false;
                        break;
                    } else {
                    }
                }
            } else {

                for (int i = 1; i < distanceX; i++) {

                    if (!(GameBoard.tt[this.x - i][this.y].getPieceColor().equals(Player.NONE))) {
                        determine = false;
                        break;
                    } else {
                    }
                }

            }

        } else if (distanceY != 0) {
            if (distanceY == 1 || distanceY == -1) {
                return true;
            }

            if (distanceY < 0) {

                for (int i = 1; i < Math.abs(distanceY); i++) {

                    if (!(GameBoard.tt[this.x][this.y + i].getPieceColor().equals(Player.NONE))) {
                        determine = false;
                        break;
                    } else {
                    }
                }
            } else {
                for (int i = 1; i < distanceY; i++) {

                    if (!(GameBoard.tt[this.x][this.y - i].getPieceColor().equals(Player.NONE))) {
                        determine = false;
                        break;
                    } else {
                    }
                }
            }

        }

        return determine;

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
