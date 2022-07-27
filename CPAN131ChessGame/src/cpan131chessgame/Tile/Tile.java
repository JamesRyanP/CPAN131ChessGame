
package cpan131chessgame.Tile;

abstract public class Tile {
    /* Tile value must be one of 3 values; 
        1) "-" for empty tile, 
        2) *player piece* for piece type eg. "wB" for white Bishop
        3) Prof asked for labeled rows and columns. eg. 0,0 5,4
            So first row and column in array must be labeled.
    */
    protected String value;
    
    protected Tile(String value){
        this.value = value;
    
    }
    
    public String getValue(){
        return value;
    } 
   
    public void setValue(String value){
        this.value = value;
    }
    
     abstract public boolean canMoveTo(int x, int y);
     
     abstract public void moveTo(int x, int y);
}
