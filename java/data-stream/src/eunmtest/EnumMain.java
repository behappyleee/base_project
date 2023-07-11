package eunmtest;

public class EnumMain {

    public static void main(String[] args) {
        int maleOrdinalIndex = EnumTest.MALE.ordinal();
        int femaleOrdinalIndex = EnumTest.FEMALE.ordinal();

        System.out.println("ENUM TEST METHOD CHECK : " + EnumTest.getGenderStrType("MALE"));

    }

}
