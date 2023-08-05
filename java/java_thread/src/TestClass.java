public class TestClass {

    public static void main(String[] args) {

        int x = 3;
        int a = x;

        for(int i=0; i<3; i++) {
            a++;
        }

        System.out.println("X VALUE : " + x);
        System.out.println("A VALUE : " + a);

        String aStr = "A";
        String bStr = aStr;

        for(int i=0; i<3; i++) {
            aStr += String.valueOf(i);
        }

        System.out.println("A STR : " + aStr);
        System.out.println("B STR : " + bStr);


    }

}
