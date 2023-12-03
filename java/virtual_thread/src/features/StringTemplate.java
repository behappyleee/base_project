package features;

public class StringTemplate  {

    public static void main(String[] args) {
        String test = "[THIS IS TEST STRING]";

        // Java 21 Version 부터 String Template 을 지원
        String template = """
                Java New Featrue 21
                String Template
                """;

        System.out.println(template);
        // STR is the template processor.
        // There is a dot operator between the processor and expression.
        String name = "StringTemplate Name";
        String message = STR."Greetings \{name}";

        System.out.println(message);

    }
}
