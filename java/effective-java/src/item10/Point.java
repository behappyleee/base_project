package item10;

public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Point))
            return false;
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

    // Broken - violates Liskov substituion principles
    // The Liskov Substitution Principle (LSP) is a principle in object-oriented programming that states that objects of a
    // superclass should be replaceable with objects of its subclasses without affecting the correctness of the program.
    // In other words, if S is a subtype of T, then objects of type T can be replaced with objects of type S without altering
    // the desired behaviour of the program.
    // @Override (원래는 함수이름 equals 위에 중복이라 equalsBroken 으로 대체)
    public boolean equalsBroken(Object o) {
        if(o == null || o.getClass() != getClass()) {
            return false;
        }
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

    @Override
    public int hashCode() {
        return 31 * x * y;
    }

}



