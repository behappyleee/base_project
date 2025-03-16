package templatemethod.beverage;

public abstract class Beverage {
    // 인터페이스가 아닌 추상메서드를 사용하는 이유 해당 메서드가 TemplateMethod 에 템플릿 역할을 해 줌
    // 추상 클래스와 인터페이스는 이로부터 확장 하거나 이를 적용한 클래스들의 카테고리가 됨
    public void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addComments();
    }

    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    abstract void brew();
    abstract void addComments();
}
