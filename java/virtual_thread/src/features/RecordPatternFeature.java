package features;

public class RecordPatternFeature {

    public static void main(String[] args) {
        TestRecord t1 = new TestRecord("TEST1", 23);
        if(t1 instanceof TestRecord t) {
            String x = t1.a();
            int b = t1.b();

            System.out.println("Test : " + x + " b : " + b);
        }

        if(t1 instanceof TestRecord(String a, int b)) {
            System.out.println("THIS IS A : " + a + " B : " + b);
        }

//        if(t1 instanceof TestRecord("Test2", 27)) {
//            System.out.println("THIS ... ?");
//        }

    }
}

record TestRecord(String a, int b){

    public String testMethod() {
        return "[TEST FOR METHOD !!]";
    }

}

