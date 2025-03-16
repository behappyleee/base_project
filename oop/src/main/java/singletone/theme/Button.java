package singletone.theme;

public class Button {
    private final String label;

    public Button(String label) {
        this.label = label;
    }

    public void display() {
        String themeColor = Theme.getInstance().getThemeColor();
        System.out.println("Button Label: " + label + " Theme Color: " + themeColor);
    }
}
