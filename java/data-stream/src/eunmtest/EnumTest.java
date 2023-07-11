package eunmtest;

import java.util.Arrays;

public enum EnumTest {
     MALE("MAN")
    ,FEMALE("WOMAN");

    String gender;

    EnumTest(String gender) {
        this.gender = gender;
    }

    public static String makeGenderStr() {
        return "THIS IS GENDER TYPE : ";
    }

    public String getGender() {
        return this.gender;
    }

    public static String getGenderStrType(String type) {
        printAllValues(type);
        System.out.println("VALUES DATA CHECK FILTER : " + EnumTest.values().toString());
        System.out.println("GET GENDER TYPE METHOD RETURN STR : " + EnumTest.values().equals(type));

        return Arrays.asList(EnumTest.values())
                .stream()
                .findFirst()
                .orElse(null)
                .toString();
    }

    public static void printAllValues(String type) {
        Arrays.stream(EnumTest.values())
                        .filter((eachEnum) -> eachEnum.getGender().equals(type))
                        .filter((elem) -> elem.gender.equals(type))
                        .findFirst();
        Arrays.asList(EnumTest.values())
                .stream()
                .forEach(System.out::println);

    }


}