package singletone.theme;

public class Theme {
    // 프로그램에서 하나에만 접근 가능한 정적 클래스임
    private static Theme instance;
    private String themeColor;

    // Theme 클래스 객체를 생성하지 못하게 함
    // private 접근 제어자 붙어 있음, 외부에서 이 생성자를 사용하지 못하게 함
    // 외부에서는 절대 이 객체 클래스 인스턴스를 접근이 불가 함
    private Theme() {
        this.themeColor = "light";  // Default Theme
    }

    public static Theme getInstance() {
        if (instance == null) {
            instance = new Theme();
        }
        return instance;
    }

    public String getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(String themeColor) {
        this.themeColor = themeColor;
    }
}
