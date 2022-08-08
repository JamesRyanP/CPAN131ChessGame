package chessgameproject;

import java.util.Scanner;

public class GameProcess {

    private GameBoard gb;
    private Scanner scanner;
    
    public GameProcess(){
        scanner = new Scanner(System.in);
        gb = new GameBoard();
        gb.printGrid();
    }   

}
