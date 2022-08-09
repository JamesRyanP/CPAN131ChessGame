package chessgameproject.GameTiles.GamePieces;

import chessgameproject.GameBoard;
import chessgameproject.Player;
import chessgameproject.GameTiles.PlayerPieces;

public class Rook extends PlayerPieces{
    
    public Rook (String value, int x, int y, Player pieceColor){
       super(value,x,y, pieceColor);
    }
    
    @Override
    public boolean canMoveTo(int x, int y) {

        Boolean determine = true;

        if (!GameBoard.tt[x][y].getPieceColor().equals(pieceColor)) {
            int distanceX = (this.x - x);
            int distanceY = (this.y - y);

            // check if the coordinate is a straight line
            if (distanceX != 0 && distanceY != 0) {
                return false;
            }

            determine = moveStraight(x, y, distanceX, distanceY);

        } else {
            return false;
        }

        return determine;
    }
    
        /**
     *
     * @param x
     * @param y
     */
    @Override
    public void moveTo(int x, int y) {
        
        switch (getPieceColor()) {
            case WHITE:
                GameBoard.tt[x][y] = new Rook("wR", x, y, Player.WHITE);
                break;
            case BLACK:
                GameBoard.tt[x][y] = new Rook("bR", x, y, Player.BLACK);
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
                    }
                }
            } else {

                for (int i = 1; i < distanceX; i++) {

                    if (!(GameBoard.tt[this.x - i][this.y].getPieceColor().equals(Player.NONE))) {
                        determine = false;
                        break;
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
                    }
                }
            } else {
                for (int i = 1; i < distanceY; i++) {

                    if (!(GameBoard.tt[this.x][this.y - i].getPieceColor().equals(Player.NONE))) {
                        determine = false;
                        break;
                    }
                }
            }

        }

        return determine;

    }
    
    
    
}
