package chessgameproject;

public class GameBoard {
    //private char[][] grid;
    private char [] num = {' ','1','2','3','4','5','6','7','8'};
    private char [] letter = {' ','A','B','C','D','E','F','G','H'};
    public static Tile [][] tt;
    public GameBoard(){ 
        tt = new Tile [9][9];
        initializeGrid();
    }
    public void initializeGrid(){
        // Sets Letters for X AXIS
        for (int i = 0; i < 9; i++){
            for (int y = i; y < letter.length; y++){
                String s = letter[y] + " ";
                tt[0][i] = new NonPlayerPiece (s, Player.NONE);
                break;
            }
            
        }
       // Sets numbers for Y AXIS
        for (int i = 0; i < 9; i++){
            for (int y = i; y < num.length; y++){
                String r = ""+ num[y];
                tt[i][0] = new NonPlayerPiece(r, Player.NONE);
                break;
            }
            
        }
        // Creates '-' for spots
        for(int i = 1; i < 9; i++){
            for (int y = 1; y < 9; y++){
                tt[i][y] = new NonPlayerPiece ("XX", Player.NONE);
            }
        }
        
        tt[1][1] = new Rook ("bR",1,1,Player.BLACK);
        tt[1][2] = new Horse ("bH", 1,2,Player.BLACK);
        tt[1][3] = new Bishop ("bB", 1,3,Player.BLACK);
        tt[1][4] = new Queen ("bQ", 1,4,Player.BLACK);
        tt[1][5] = new King ("bK",1,5,Player.BLACK);
        tt[1][6] = new Bishop ("bB", 1,6,Player.BLACK);
        tt[1][7] = new Horse ("bH",1,7,Player.BLACK);
        tt[1][8] = new Rook ("bR", 1,8,Player.BLACK);
        
        for(int i = 1; i < 9; i++){
            tt[2][i] = new Pawn ("bP",2,i,Player.BLACK);
        }
        
        tt[8][1] = new Rook ("wR",8,1,Player.WHITE);
        tt[8][2] = new Horse ("wH", 8,2,Player.WHITE);
        tt[8][3] = new Bishop ("wB", 8,3,Player.WHITE);
        tt[8][4] = new Queen ("wQ", 8,4,Player.WHITE);
        tt[8][5] = new King ("wK",8,5,Player.WHITE);
        tt[8][6] = new Bishop ("wB", 8,6,Player.WHITE);
        tt[8][7] = new Horse ("wH",8,7,Player.WHITE);
        tt[8][8] = new Rook ("wR", 8,8,Player.WHITE);
        
        for(int i = 1; i < 9; i++){
            tt[7][i] = new Pawn ("wP",7,i,Player.WHITE);
        }
       
    }
    
    public void printGrid() {
        for (int i = 0; i < 9; i++) {
            for (int y = 0; y < 9; y++) {
                System.out.print(tt[i][y].getValue() + " ");
            }
            System.out.println();
        }
    }
}

// Tile (super) -- > Pi
// 
