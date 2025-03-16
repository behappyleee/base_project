package singletone;

import singletone.theme.Button;
import singletone.theme.Label;
import singletone.theme.TextField;
import singletone.theme.Theme;

public class SingletonPattern {

    // 싱글톤은 매우 중요한 패턴
    // 이 패턴은 프로그램에서 특정 클래스의 객체가 단 하나만 존재하여야 할 때 사용

    // instance vs static
    // 인스턴스 요소들은 새로운 인스턴스 객체가 만들어 질 때마다 계속 새로 생성 됨
    // 정적 요소들은 만들어지는 인스턴수 갯수와 상관없이 딱 하나만 생성이 됨
    // 프로그램에는 딱 한개만 데이터가 존재할 필요가 있음

    public static void main(String[] args) {
        // 각 클래스들 안에서는 Theme 싱글톤 클래스로 접근을 하므로 동일한 객체에 접근한 다는 것을 보장
        // 해당 클래스안에서 참조되는 Theme 클래스들은 동일한 Theme 클래스 들임 !

        // 이 싱글톤 클래스를사용하게 된다면 어떤 클래스의 객체가 두개 이상 존재하여 발생하는 문제들을 해결이 가능
        Button button = new Button("Submit");
        TextField textField = new TextField("Enter your name");
        Label label = new Label("Enter your age");

        button.display();
        textField.display();
        label.display();

        Theme.getInstance().setThemeColor("dark");

        button.display();
        textField.display();
        label.display();
    }
}
