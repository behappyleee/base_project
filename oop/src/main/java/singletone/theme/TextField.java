package singletone.theme;

public class TextField {
    private final String text;

    public TextField(String text) {
        this.text = text;
    }

    public void display() {
        String themeColor = Theme.getInstance().getThemeColor();
        System.out.println("Text Field : " + text + " Theme Color : " + themeColor);
    }
}
