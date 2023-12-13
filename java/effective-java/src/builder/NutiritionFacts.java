package builder;

public class NutiritionFacts {

    // Builder Pattern 사용 이유
    // 1. 필요한 데이터만 설정이 가능
    // 2. 유연성 확보가 가능
    // 3. 가독성을 높일 수 있음
    // 4. 불변성 확보가 가능

    // setter 를 사용 한다는 것은 불빌요 하게 확장 가능성을 열어두는 것이다.
    // 이는 Open-Closed 법칙에 위배되고 불필요한 코드리딩을 유발 그렇기 때문에
    // 클래스 변수를 final 로 선언을 하고 객체의 생성은 빌더에 맡기는 것이 좋다.

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohybrate;

    public static class Builder {
        // required parameters
        private final int servingSize;
        private final int servings;

        // Optional Parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            this.calories = val;
            return this;
        }

        public Builder fat(int val) {
            this.fat = val;
            return this;
        }

        public Builder sodium(int val) {
            this.sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            this.carbohydrate = val;
            return this;
        }

        public NutiritionFacts build() {
            return new NutiritionFacts(this);
        }
    }

    // 생성자를 private 으로 생성 !
    private NutiritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohybrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        NutiritionFacts cocaCola = new Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();

        System.out.println("COCA COLA 1 : " + cocaCola);
        System.out.println("COCA COLA 2 : " + cocaCola.toString());

    }

}
