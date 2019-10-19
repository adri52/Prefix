public class Main {

    public static void main(String[] args) {
        // write your code here
        Prefix prefix1  = new Prefix();

        System.out.println("This program will recieves a prefix expression and then will display the answer.");
        System.out.println("Example:");
        System.out.println("We have a prefix expression: ");
        System.out.println("/ + 170 10 - 90 60 ");
        prefix1.changeExpr("/ + 170 10 - 90 60");

        int start  = prefix1.getStart();
        int stop  = prefix1.getStop();

        int result = prefix1.Pre(start,stop).answ;
        System.out.println("The product of this prefix is: "+result);

    }

}
