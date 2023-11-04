import java.util.Arrays;

public enum EnumTest {
      HAPPY("happy")
    , SMILE("smile")
    , LOVE("love");

    EnumTest(String enumValue) {}

    public static String getValue(EnumTest enumType) {
        return EnumTest.valueOf(enumType.toString()).toString();
    }

    public static void main(String[] args) {
        String check = getValue(EnumTest.HAPPY);
        System.out.printf("[GET VALUE ] : {} " , check);
    }

}
