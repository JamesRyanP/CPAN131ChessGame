package chessgameproject;

import chessgameproject.Exceptions.Invalid;

public class CoordinateConverter {
    
    
    public int[] convertCoordinates (String position) throws Invalid {
        
        String coordx = position.substring(0, 1).toLowerCase();
        String coordy = position.substring(1, 2);
        
        if (position.length() > 2) {
            throw new Invalid("Invalid Input");
        } 
        
        int[] coordinates = new int[2];
        
        // determines column level 
        switch (coordx) {
            case "a" -> coordinates[0] = 1;
            case "b" -> coordinates[0] = 2;
            case "c" -> coordinates[0] = 3;
            case "d" -> coordinates[0] = 4;
            case "e" -> coordinates[0] = 5;
            case "f" -> coordinates[0] = 6;
            case "g" -> coordinates[0] = 7;
            case "h" -> coordinates[0] = 8;
            default -> throw new Invalid("Invalid Input, chose another set of coordinate!");
        }
        
        // determines row level
        switch (coordy) {
            case "1" -> coordinates[1] = 8;
            case "2" -> coordinates[1] = 7;
            case "3" -> coordinates[1] = 6;
            case "4" -> coordinates[1] = 5;
            case "5" -> coordinates[1] = 4;
            case "6" -> coordinates[1] = 3;
            case "7" -> coordinates[1] = 2;
            case "8" -> coordinates[1] = 1;
            default -> throw new Invalid("Invalid Input, chose another set of coordinate");
        }
        
        return coordinates;
        
    }   
}