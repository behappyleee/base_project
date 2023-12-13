package enums;

// Singleton with public final field (Page 17 page)
public class FieldElvis {

    public static final FieldElvis INSTANCE = new FieldElvis();

    private FieldElvis() {};

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here !!");
    }

    // This code would normally appear outside the class !!!
    public static void main(String[] args) {
        FieldElvis elvis = FieldElvis.INSTANCE;
        elvis.leaveTheBuilding();

        System.out.println("ELVIS TO STRING : " + elvis.toString());

        FieldElvis elvis2 = FieldElvis.INSTANCE;

        // 주소 값이 똑같음 ! SingleTone Pattern 이므로 한번 생성 된 객체만 재사용 함 !
        System.out.println("ELVIS 2 TO STRING : " + elvis2.toString());

    }

}
