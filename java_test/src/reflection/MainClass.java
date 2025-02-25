package reflection;

public class MainClass {
    public static void main(String[] args) {
        Cat myCat = new Cat(3, "Cat Name !");
        Object aaa = myCat.getClass();

        System.out.println(aaa);
    }
}
