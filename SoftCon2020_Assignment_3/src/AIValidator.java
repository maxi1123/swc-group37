public class AIValidator {

    public boolean ValidateCoordinates(String position, Grid AIGrid){
        Transformer t = new Transformer();
        int LetterPos = t.transformCoord(position.charAt(0));
        int NumberPos = position.charAt(1);
        if (position.length() == 2){
            if(LetterPos <= 9 && NumberPos <= 9){
                if( AIGrid.grid[NumberPos][LetterPos] == "[ ]"){
                    return true;
                }
            }
        }
        return false;
    }
}
