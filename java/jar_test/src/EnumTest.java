import java.util.Arrays;
import java.util.stream.Stream;

public enum EnumTest {
      HAPPY("happy")
    , SMILE("smile")
    , LOVE("love");

    private String strValue;

    EnumTest(String enumValue) {
        this.strValue = enumValue;
    }

    public static String getValue(EnumTest enumType) {
        return  Stream.of(values())
                .filter(value -> value.equals(enumType))
                .findAny()
                .orElse(null)
                .name();
    }

    public String getStrValue() {
        return strValue;
    }

    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    public static void main(String[] args) {
        String check = getValue(EnumTest.HAPPY);

        System.out.printf("check : " + check);
    }

}
