package templatemethod.beverage;

public class Coffee extends Beverage {

    @Override
    void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    void addComments() {
        System.out.println("Adding sugar and milk");
    }
}
