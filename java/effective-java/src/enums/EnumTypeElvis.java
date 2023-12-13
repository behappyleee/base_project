package enums;

public enum EnumTypeElvis {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("Whoa Baby, I'm outta here !!");
    }

    public static void main(String[] args) {
        EnumTypeElvis elvis = EnumTypeElvis.INSTANCE;

        System.out.println("ELVIS TO STRING : " + elvis.toString());

        elvis.leaveTheBuilding();

        EnumTypeElvis elvis2 = EnumTypeElvis.INSTANCE;

        System.out.println("ELVIS2 TO STRING : " + elvis2.toString());

    }
}
