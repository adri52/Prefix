public class Prefix {
    private String expr = "* + 3 2 - 9 7";


    private class Help {
        int result;
        int index;

        Help(){
            result =0;
            index = expr.indexOf(expr);
        }
    }

    private Help type = new Help();


    public Help pre(int start) {
        char op;
        int x, y;
        if (expr.charAt(start) < 48 && expr.charAt(start + 2) >= 48) {
            op = expr.charAt(start);
            x = Character.getNumericValue(expr.charAt(start + 2));
            y = Character.getNumericValue(expr.charAt(start + 4));

            if(op == '+')
                type.result = x + y;
            else if(op == '-')
                type.result = x - y;
            else if(op == '*')
                type.result = x * y;
            else if(op == '/')
                type.result = x / y;

            type.index = start;
            return type;
        } else {
            Help endFirst = pre(start + 2);
            Help endSec = pre(endFirst.index + 2);
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

    public int getStop(){ return expr.length() -1; }
}
