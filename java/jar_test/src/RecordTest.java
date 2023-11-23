
public class RecordTest {

    public static void main(String[] args) {

        RecordCheck r1 = new RecordCheck("Test", 23);
        r1.age();
        r1.name();
    }

}

record RecordCheck(String name, int age) {}