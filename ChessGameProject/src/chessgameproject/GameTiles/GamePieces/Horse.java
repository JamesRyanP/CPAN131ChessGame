package chessgameproject.GameTiles.GamePieces;

import chessgameproject.GameBoard;
import chessgameproject.Player;
import chessgameproject.GameTiles.PlayerPieces;

public class Horse extends PlayerPieces {

    public Horse(String value, int x, int y, Player pieceColor) {
        super(value, x, y, pieceColor);
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    @Override
    public boolean canMoveTo(int x, int y) {

        if (!GameBoard.tt[x][y].getPieceColor().equals(pieceColor)) {
            int distanceX = Math.abs(this.x - x);
            int distanceY = Math.abs(this.y - y);

            return distanceX == 2 && distanceY == 1 || distanceY == 2 && distanceX == 1;
        } else {
            return false;
        }

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
                GameBoard.tt[x][y] = new Horse("wH", x, y, Player.WHITE);
                break;
            case BLACK:
                GameBoard.tt[x][y] = new Horse("bH", x, y, Player.BLACK);
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