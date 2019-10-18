public class Main {

    public static void main(String[] args) {
        // write your code here
        Prefix prefix1  = new Prefix();

        prefix1.changeExpr("/ + 170 10 - 90 60");

        int start  = prefix1.getStart();
        int stop  = prefix1.getStop();

        int result = prefix1.Pre(start,stop).answ;
        System.out.println(result);





    }

}
