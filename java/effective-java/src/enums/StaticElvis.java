package enums;

public class StaticElvis {

    private static final StaticElvis INSTANCE = new StaticElvis();

    private StaticElvis() {}

    public static StaticElvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I am outta here !!");
    }

    public static void main(String[] args) {
        StaticElvis elvis = StaticElvis.getInstance();
        elvis.leaveTheBuilding();

        StaticElvis elvis2 = StaticElvis.getInstance();

        // 싱글톤 객체이므로 객체를 생성 하였지만 모두 값이 동일 함 !
        System.out.println("ELVIS TO STRING : " + elvis.toString());
        System.out.println("ELVIS2 TO STRING : " + elvis2.toString());

    }

}
