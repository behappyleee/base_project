package templatemethod.beverage;

import lombok.Getter;

public class Tea extends Beverage {
    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addComments() {
        System.out.println("Adding lemon");
    }

//    class Test {
//
//        @Getter
//        public Test(String a) {
//
//        }
//        int a;
//
//        public void testCheck() {
//
//        }
//
//        public String getTest() {
//            return "THIS IS TEST !";
//        }
//    }
//
//    public static void main(String[] args) {
//        Test test = new Test("SDsdd");
//        test.testCheck();
//        test.getTest();
//    }
}
