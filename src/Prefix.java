public class Prefix {
    private String expr = "* + 3 12 - 9 7";


    private class Help {
        int result;
        int index;
    }

    private Help type = new Help();


    public Help pre(int start, int stop) {
        char c = expr.charAt(start);
        if (c >= 48) {
            type.index = start;
            type.result = Character.getNumericValue(c);
            return type;
        } else {
            Help endFirst = pre(start + 2, stop);
            Help endSec = pre(endFirst.index + 1, stop);
            return endSec;
        }
    }

    public void changeExpr(String newExpr){
        expr = newExpr;
    }

    public String getExpr(){
        return expr;
    }

    public int getResult(){
        return type.result;
    }

    public int getIndex(){
        return type.index;
    }
}
