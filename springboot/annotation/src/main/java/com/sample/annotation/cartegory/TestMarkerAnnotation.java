package com.sample.annotation.cartegory;

public class TestMarkerAnnotation {

    public static void main(String[] args) {
        XYZClient client = new XYZClient();
        Class clientClass = client.getClass();

        boolean isExistAnnotation = checkAnnotation(clientClass);

        System.out.println("IS ANNOTATION CURRENT PRESENT DATA CHECK : " + clientClass.isAnnotationPresent(CSV.class));

        // CSV Annotation 이 존재하느냐에 따라 CSV File 일지 Excel 파일일지 결정이 가능
        if(clientClass.isAnnotationPresent(CSV.class)) {
            System.out.println("Write Client Data to CSV");
        } else {
            System.out.println("Write client data to Excel files.");
        }
    }

    public static boolean checkAnnotation(Class<?> currentClass) {
        return currentClass.isAnnotationPresent(CSV.class);
    }

}
