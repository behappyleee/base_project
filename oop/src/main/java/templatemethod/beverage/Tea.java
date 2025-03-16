package templatemethod.beverage;

public class Tea extends Beverage {
    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addComments() {
        System.out.println("Adding lemon");
    }
}
