package chessgameproject.GameTiles.GamePieces;

import chessgameproject.GameBoard;
import chessgameproject.Player;
import chessgameproject.GameTiles.PlayerPieces;

public class Pawn extends PlayerPieces {


    public Pawn (String value, int x, int y, Player pieceColor){
        super(value,x,y, pieceColor);

    }

    @Override
    public boolean canMoveTo(int x, int y){
        
        Boolean determine = true;
        
        if (!GameBoard.tt[x][y].getPieceColor().equals(pieceColor)) {
            int distanceX = this.x - x;
            int distanceY = this.y - y;
            
            if(distanceY != 0) {
                if(Math.abs(distanceX) == 1) {
                    
                } else {
                    return false;
                }
            }

            Boolean firstMove;

            // check if coordinates entered are within bounds
            if (pieceColor.equals(Player.WHITE)) {
                if (this.x == 7) {
                    
                    firstMove = true;

                    if (distanceX > 2) {
                        return false;
                    } 
                } else {
                    
                    firstMove = false;
                    
                    if (distanceX != 1) {
                        return false;
                    }
                }
            } else {
                if (this.x == 2) {
                    
                    firstMove = true;

                    if (distanceX < -2) {
                        return false;
                    }
                } else {
                    firstMove = false;
                    
                    if (distanceX != -1) {
                        return false;
                    }
                }
            }
            
        determine = pawnMoveCheck(x, y, distanceX, distanceY, firstMove);
            
        } else {
            return false;
        }

        return determine;
    }

    @Override
    public void moveTo(int x, int y) {
        
        switch (getPieceColor()) {
            case WHITE:
                GameBoard.tt[x][y] = new Pawn("wP", x, y, Player.WHITE);
                break;
            case BLACK:
                GameBoard.tt[x][y] = new Pawn("bP", x, y, Player.BLACK);
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
    
    public Boolean pawnMoveCheck(int x, int y, int distanceX, int distanceY, Boolean firstMove) {
        
        Boolean determine = true;
        
        if (pieceColor.equals(Player.WHITE)) {
                if(firstMove && Math.abs(distanceX) == 2 ) {
                    if(distanceX == 2 && distanceY == 0) {
                        for (int i = 1; i <= 2; i++) {
                            
                            if (!(GameBoard.tt[this.x - i][this.y].getPieceColor().equals(Player.NONE))) {
                                
                                determine = false;
                                break;
                            }
                        }
                    } else if ((distanceX == 1) && (distanceY == 0)) {
                        if (!(GameBoard.tt[x][y].getPieceColor().equals(Player.NONE))) {
                                determine = false; 
                            }
                    } else if (x == (this.x - 1) && y == (this.y + 1) || x == (this.x - 1) && y == (this.y - 1)) {
                        if ((GameBoard.tt[x][y].getPieceColor().equals(pieceColor)) || (GameBoard.tt[x][y].getPieceColor().equals(Player.NONE))) {
                            determine = false; 
                        }
                    }
                        
                    } else {

                        if ((distanceX == 1) && (distanceY == 0)) {
                            
                            if (!(GameBoard.tt[x][y].getPieceColor().equals(Player.NONE))) {
                                
                                determine = false;
                            }
                        } else if (x == (this.x - 1) && y == (this.y + 1) || x == (this.x - 1) && y == (this.y - 1)) {
                            
                            if ((GameBoard.tt[x][y].getPieceColor().equals(pieceColor)) || (GameBoard.tt[x][y].getPieceColor().equals(Player.NONE))) {
                                determine = false;
                            }
                        }
                    } 
                
                
            } else {    
                if(firstMove && Math.abs(distanceX) == 2) {
                    if(distanceX == -2 && distanceY == 0) {
                        for (int i = 1; i <= 2; i++) {
                            
                            if (!(GameBoard.tt[this.x + i][this.y].getPieceColor().equals(Player.NONE))) {
                                
                                determine = false;
                                break;
                            }
                        }
                    } else if ((distanceX == -1) && (distanceY == 0)) {
                        if (!(GameBoard.tt[x][y].getPieceColor().equals(Player.NONE))) {
                                determine = false; 
                            }
                    } else if (x == (this.x + 1) && y == (this.y + 1) || x == (this.x + 1) && y == (this.y - 1)) {
                        if ((GameBoard.tt[x][y].getPieceColor().equals(pieceColor)) || (GameBoard.tt[x][y].getPieceColor().equals(Player.NONE))) {
                            determine = false; 
                        }
                    }
                        
                    } else {

                        if ((distanceX == 1) && (distanceY == 0)) {
                            if (!(GameBoard.tt[x][y].getPieceColor().equals(Player.NONE))) {
                                determine = false;
                            }
                        } else if (x == (this.x - 1) && y == (this.y + 1) || x == (this.x - 1) && y == (this.y - 1)) {
                            if ((GameBoard.tt[x][y].getPieceColor().equals(pieceColor)) || (GameBoard.tt[x][y].getPieceColor().equals(Player.NONE))) {
                                determine = false;
                            }
                        }
                    }    
                }
        
        return determine;
    }

}
