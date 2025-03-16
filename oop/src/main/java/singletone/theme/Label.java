package singletone.theme;

public class Label {
    private final String text;

    public Label(String text) {
        this.text = text;
    }

    public void display() {
        String themeColor = Theme.getInstance().getThemeColor();
        System.out.println("Label Text : " + text + "  Theme Color : " + themeColor);
    }
}

