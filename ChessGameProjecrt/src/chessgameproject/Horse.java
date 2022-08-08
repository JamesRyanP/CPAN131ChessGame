package chessgameproject;

public class Horse extends PlayerPieces {

    public Horse(String value, int x, int y, Player pieceColor) {
        super(value, x, y, pieceColor);
    }

    // No reason to have setter for pieceColor as it will never change // 
    @Override
    public boolean canMoveTo(int x, int y) {

        if (!GameBoard.tt[x][y].getPieceColor().equals(pieceColor)) {
            int distanceX = Math.abs(this.x - x);
            int distanceY = Math.abs(this.y - y);

            if (distanceX == 2 && distanceY == 1 || distanceY == 2 && distanceX == 1) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }

    @Override
    public void moveTo(int x, int y) {

    }
}
