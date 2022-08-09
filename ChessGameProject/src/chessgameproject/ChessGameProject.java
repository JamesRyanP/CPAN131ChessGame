package chessgameproject;

import chessgameproject.Exceptions.Invalid;
import chessgameproject.GameTiles.EmptyTile.EmptyTile;
import java.util.Scanner;

public class ChessGameProject {

    private static GameBoard gb;

    public static void main(String[] args) {

        gb = new GameBoard();

        String move1;
        String move2;

        int victor = 0;

        String playerTurn = "WHITE";
        Boolean correctPiece;

        do {

            // infinite loop on purpose so breaks in the program don't interfere with player turn
            while (victor == 0) {

                gb.printGrid();

                /*
                do while that loops until correct coordinates are input
                 */
                do {

                    System.out.println("\nChoose a piece to move: " + playerTurn + " players turn. Eg. 'A2' ");
                    move1 = CoordinatesMoveFrom();

                    System.out.println("\nChoose piece destination: " + playerTurn + " players turn. Eg. 'A3' ");
                    move2 = CoordinatesMoveTo();

                    System.out.println("_________________________");
                    System.out.println("");

                } while (move2.equals(""));

                // setting up move from coordinates
                int xPrev = convertToCoordinates(move1, 1);
                int yPrev = convertToCoordinates(move1, 0);

                /* 
                Check to see whether the player is moving their own piece
                 */
                if (playerTurn.equals("WHITE")) {
                    correctPiece = GameBoard.tt[xPrev][yPrev].getPieceColor().equals(Player.WHITE);

                } else {
                    correctPiece = GameBoard.tt[xPrev][yPrev].getPieceColor().equals(Player.BLACK);
                }

                /*
                If player is not moving their piece, the loop is ended
                 */
                if (!(correctPiece)) {
                    System.out.println("Incorrect piece\n");
                    break;
                }

                // setting up moveTo coordinates
                int xFuture = convertToCoordinates(move2, 1);
                int yFuture = convertToCoordinates(move2, 0);

                if (xPrev == xFuture && yPrev == yFuture) {
                    System.out.println("Cannot select same coordinate");
                    break;
                }

                /*
                Checks if piece can be moved to the spot, 
                if able: moves the piece 
                    and removes the old coordinate information
                if unable: restarts the whole loop
                 */
                if (GameBoard.tt[xPrev][yPrev].canMoveTo(xFuture, yFuture)) {

                    if (GameBoard.tt[xFuture][yFuture].getValue().substring(1, 2).equals("K")) {
                        if (playerTurn.equals("WHITE")) {
                            victor = 1;
                        } else {
                            victor = 2;
                        }
                    }

                    // set up for next players turn | WHITE -> BLACK -> WHITE... |
                    if (GameBoard.tt[xPrev][yPrev].getPieceColor().equals(Player.WHITE)) {
                        playerTurn = "BLACK";
                    } else {
                        playerTurn = "WHITE";
                    }

                    completeMove(xPrev, yPrev, xFuture, yFuture);

                    // Wipes the old coordinates of piece
                    GameBoard.tt[xPrev][yPrev] = new EmptyTile("XX", Player.NONE);

                } else {
                    System.out.println("CANNOT MOVE THERE\n");
                }

            }

        } while (victor == 0);

        if (victor == 1) {
            System.out.println("\n---------------------------");
            System.out.println("---------White Wins--------");
            System.out.println("---------------------------");
        } else {
            System.out.println("---------------------------");
            System.out.println("---------Black Wins--------");
            System.out.println("---------------------------\n");
        }

        System.out.println("---Thank you for playing---");

    }

    public static String CoordinatesMoveFrom() {

        CoordinateConverter obj = new CoordinateConverter();

        Boolean checkpoint1;
        String movement = "";

        do {
            try {
                checkpoint1 = true;

                String move1 = getCoordinatesInput();

                int x[] = obj.convertCoordinates(move1);

                movement = "" + x[0] + x[1];

            } catch (Invalid z) {
                System.out.println(z.getMessage());
                checkpoint1 = false;
            }
        } while (!(checkpoint1));

        return movement;
    }

    public static String CoordinatesMoveTo() {

        CoordinateConverter obj = new CoordinateConverter();

        String movement;

        try {

            String move2 = getCoordinatesInput();

            int x[] = obj.convertCoordinates(move2);

            movement = "" + x[0] + x[1];

        } catch (Invalid z) {
            System.out.println(z.getMessage());
            movement = "";
        }

        return (movement);
    }

    public static void completeMove(int x, int y, int xMoveTo, int yMoveTo) {

        GameBoard.tt[x][y].moveTo(xMoveTo, yMoveTo);

    }

    public static String getCoordinatesInput() {

        Scanner scan = new Scanner(System.in);

        String userCoordinates;

        do {

            userCoordinates = scan.next();

            if (userCoordinates.length() == 1 || 2 < userCoordinates.length()) {
                System.out.println("Please enter a valid coordinate");
            }

        } while (userCoordinates.length() == 1 || 2 < userCoordinates.length());

        return (userCoordinates);

    }

    public static int convertToCoordinates(String fullCoordinate, int indent) {

        int coordinate;

        if (indent == 0) {
            coordinate = Integer.parseInt(fullCoordinate.substring(0, 1));
        } else {
            coordinate = Integer.parseInt(fullCoordinate.substring(1, 2));
        }

        return coordinate;
    }

}
