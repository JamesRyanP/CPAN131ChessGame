package chessgameproject;

public class Horse extends PlayerPieces {

    public Horse(String value, int x, int y, Player pieceColor) {
        super(value, x, y, pieceColor);
    }

    // No reason to have setter for pieceColor as it will never change // 
    @Override
    public boolean canMoveTo(int x, int y) {
        int distanceX = Math.abs(this.x - x);
        int distanceY = Math.abs(this.y - y);
          System.out.println(distanceX);
            System.out.println(distanceY);
        if (!GameBoard.tt[x][y].getPieceColor().equals(pieceColor)) {
            System.out.println("not same color");

            if (distanceX == 2 && distanceY == 1 || distanceY == 2 && distanceX == 1) {
                System.out.println("move allowed");
                return true;
            } else {
                System.out.println("move not allowed");
                return false;
            }

        } else {

            System.out.println("same color");
            return false;
        }

    }

    @Override
    public void moveTo(int x, int y) {

    }
}
