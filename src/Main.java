public class Main {
    public static void main(String[] args){
        Prefix prefix = new Prefix();
        System.out.println(prefix.getExpr());

        String expr = "* + 3 12 - 9 7";
        prefix.pre(0);
        System.out.println(prefix.getIndex());
        System.out.println(prefix.getResult());


        //System.out.println(prefix.getIndex());

    }

}
