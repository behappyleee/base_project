package comparator;

import java.util.Arrays;
import java.util.Comparator;

public class HeightCompareTest {

    static class Person {
        String name;
        int age;
        int height;

        Person(String name, int age, int height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        static final Comparator<Person> HEIGHT_ORDER = new HeightOrderComparator();

        static class HeightOrderComparator implements Comparator<Person> {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.height, o2.height);
            }
        }
    }

    public static void main(String[] args) {
        Person[] people = new Person[] {
            new Person("John", 20, 178),
            new Person("Aiden", 21, 183),
            new Person("Mac", 27, 176)
        };

        var test = Arrays.binarySearch(
            people,
            new Person("Mike", 23, 183),
            Person.HEIGHT_ORDER
        );


    }
}
