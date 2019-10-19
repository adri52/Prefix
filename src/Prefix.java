import java.util.Stack;


//Wre create the prefix class
public class Prefix {
    private String expr = "* + 3 2 - 9 7";


    //This class we have it and it will hold all the different
    //answers and index the prefix will fo trough to get solved
    public class Result {
        int answ;
        int index;

        public Result(){
            answ =0;
            index = expr.indexOf(expr);
        }
    }



    //This a the function that will recurs and basically solve the prefix expression
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

    //This function will recive an character (which will ba an operator) and then compare to wich operatio it fits
    //and then operate the two values.
    private int evaluate(char op, int x, int y){


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


    //This is for the menu, which will allow to change the expression that is alreeady implemented in the prefix class.
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
