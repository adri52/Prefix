import java.util.Stack;

public class Prefix {
    private String expr = "* + 3 2 - 9 7";




    public class Result {
        int answ;
        int index;

        public Result(){
            answ =0;
            index = expr.indexOf(expr);
        }

        public int getAnsw() {
            return answ;
        }

        public int getIndex() {
            return index;
        }
    }


    public Result Pre(int start, int stop){


        char c = expr.charAt(start);

        Result preFinal = new Result();

        Result ex1 = new Result();

        Result ex2 = new Result();

        if(c >= 48){
            int temp = start;
            while(expr.charAt(temp)!= 32)
                temp++;

            preFinal.index = temp;
            preFinal.answ = Integer.valueOf(expr.substring(start, temp));
            return preFinal;
        }
        else {
            ex1 = Pre(start + 2, stop);
            ex2 = Pre(ex1.index + 1, stop);

            preFinal.index = ex2.index;
            preFinal.answ = evaluate(c, ex1.answ, ex2.answ);
        }

        return preFinal;

    }


    public int evaluate(char op, int x, int y){


        int result = 0;

        if(op == '+')
            result = x + y;
        else if(op == '-')
            result = x - y;
        else if(op == '*')
            result = x * y;
        else if(op == '/')
            result = x / y;
        return result;
    }



    public void changeExpr(String newExpr){
        newExpr = newExpr + " ";
        expr = newExpr;
    }

    public String getExpr(){
        return expr;
    }

    public int getStart(){
        return expr.indexOf(expr.charAt(0));
    }
    public int getStop(){ return expr.length() -1; }

}
