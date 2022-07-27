package cpan131chessgame.Tile;

public class EmptyTile extends Tile {

    public EmptyTile(String value) {
        super(value);
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        System.out.println("No piece at: " + x + "," + y);
        return false;
    }

    @Override
    public void moveTo(int x, int y) {

    }
}
