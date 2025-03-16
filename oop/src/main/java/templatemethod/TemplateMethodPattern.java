package templatemethod;

import templatemethod.beverage.Beverage;
import templatemethod.beverage.Coffee;
import templatemethod.beverage.Tea;
import templatemethod.data.CSVDataProcessor;
import templatemethod.data.DataProcessor;
import templatemethod.data.JSONDataProcessor;

public class TemplateMethodPattern {

    // 템플릿 메서드 패턴 - 정해진 어떤 단계들을 거쳐 수행되어야 할 때 유용한 패턴
    // 템플릿 메서드 패턴은 구현한 알고리즘은 고정 되어 있지만 그 세부 과정 각각은 변경되거나 확장될 수 있는 경우에 유용하게 활용이 가능
    public static void main(String[] args) {
        Beverage tea = new Tea();
        Beverage coffee = new Coffee();

        System.out.println("Making Tea");
        tea.prepareRecipe();

        System.out.println("Making Coffee");
        coffee.prepareRecipe();

        // 각 파일에 맞는 Processor 객체들을 생성
        DataProcessor jsonProcessor = new JSONDataProcessor();
        DataProcessor csvProcessor = new CSVDataProcessor();


    }
}
