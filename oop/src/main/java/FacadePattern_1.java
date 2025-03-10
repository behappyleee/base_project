public class FacadePattern_1 {
    // Facade Pattern - 어떤 건물 외벽을 의마하는 프랑스어
    // 이 패턴은 드라이브 스르와 비슷한 패턴임, 손님들은 가게 내부 구조를 알 필요 없이 해당 창구를 통해 서비스를 제공 받음, 하나의 창고를 이용
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat();
        Lights lights = new Lights();
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        // Facade Pattern 덕분에 내부 클래스 구조를 알 필요가 없다 !
        SmartHomeFacade facade = new SmartHomeFacade(thermostat, lights, coffeeMaker);
        facade.wakeUp();
        facade.leaveHome();
    }
}

// SmartHomeFacade - Facade 역할을 해 줌 !
// SmartHomeFacade 가 없으면 일일이 절차 적으로 실행 시켜주어야 함 !
// Facade 클래스 덕에 내부 클래스 구조를 알 필요가 없음 !
class SmartHomeFacade {
    private final Thermostat thermostat;
    private final Lights lights;
    private final CoffeeMaker coffeeMaker;

    public SmartHomeFacade(Thermostat thermostat, Lights lights, CoffeeMaker coffeeMaker) {
        this.thermostat = thermostat;
        this.lights = lights;
        this.coffeeMaker = coffeeMaker;
    }

    public void wakeUp() {
        System.out.println("Waking Up ... !!");
        lights.on();
        coffeeMaker.brewCoffee();
    }

    public void leaveHome() {
        System.out.println("Leaning Home !");
        thermostat.setTemperature(18);
        lights.off();
    }
}



// 집주인은 기상 시 불을 켜고 커피를 내림
class Thermostat {
    public void setTemperature(int temperature) {
        System.out.println("Setting thermostat to " + temperature);
    }
}

class Lights {
    public void on() {
        System.out.println("Lights are on");
    }

    public void off() {
        System.out.println("Lights are off");
    }
}

class CoffeeMaker {
    public void brewCoffee() {
        System.out.println("Brewing coffee");
    }
}
