public class Transformer {
    public static int transformCoord(char coordinate){
        String charlist = "ABCDEFGHIJ";
        return charlist.indexOf(coordinate);
    }
    public static String inverseTransform(int coordinate){
        String[] charlist = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        return charlist[coordinate];
    }
    public static String IntToStringTransform1(int one, int two){
       return inverseTransform(one) + two;
    }
}
