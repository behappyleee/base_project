package com.book.cleancode.chapter_9;

import java.util.Objects;

public class SRP_Example {


}

// 직원 정보를 담당하는 Employee_SRP 에는 4가지 주요 메서드가 존재
class Employee_SRP {
    String name;
    String position;

    Employee_SRP(String name, String position) {
        this.name = name;
        this.position = position;
    }

    // * 초과 근무 시간을 계산하는 메서드 (두 팀에서 공유하여 사용)
    // 만약 회계팀에서 급여 계산 방식에 변경이 있어 코드에서 초과 근무 시간을 계산하는 로직 업데이트가 필요해지면
    // calculateExtraHour() 를 수정 하면 reportHours() 메서드도 영향을 주게 되어 버린다 (공유해서 사용되어 지니까)
    // 그리고 인사팀에서는 이러한 변경사실을 알지 못하고 메서드 변환 결과 값 데이터가 잘 못 되었다며 개발팀에 새로윤 요청을 보내게 될 것이다.
    // 바로 이러한 상황이 SRP 위배 된 것이다. Employee 클래스에서 회계팀, 인사팀, 기술팀 이렇게 3개의 액터에 대한 책임을 한꺼번에
    // 책임을 가지고 있기 때문

    // 액터는 시스템을 수행하는 역학을 하는 요소로써 시스템을 이용하는 사용자 하드웨어 혹은 외부 시스템이 될 수 있다.
    void calculateExtraHour() {
        // ...
    }

    // * 급여를 계산하는 메서드 (회계팀에서 사용)
    void calculatePay() {
        // ...
        this.calculateExtraHour();
        // ...
    }

    // * 근무시간을 계산하는 메서드 (인사팀에서 사용)
    void reportHours() {
        // ...
        this.calculateExtraHour();
        // ...
    }

    // * 변경된 정보를 DB에 저장하는 메서드 (기술팀에서 사용)
    void saveDababase() {
        // ...
    }
}


// * 통합 사용 클래스
// 단일 책임의 적용은 어렵지 않다. 각 책임(기능 담당)에 맞게 클래스를 분리하여 구성하면 끝이다.
// 회계팀, 인사팀, 기술팀의 기능 담당은 PayCaculator, HourReporter, EmployeeSaver 각기 클래스로 분리하고, 이를 통합적으로 사용하는 클래스인 EmployeeFacade 클래스를 만든다.
// EmployeeFacade 클래스의 메서드에는 사실상 아무런 로직이 들어있지 않게 된다. 있는 코드라 봤자 생성자로 인스턴스를 생성하고 각 클래스의 메서드를 사용하는 역할만 할 뿐이다.
// Facade 란 건물의 정면을 의미, Facade Pattern 은 말 그대로 건물의 뒷 부분이 어떻게 생겼는 지 보여주지않고 건물의 정면만 보여주는 패턴이다.

class EmployeeFacade {
    private String name;
    private String positon;

    EmployeeFacade(String name, String position) {
        this.name = name;
        this.positon = position;
    }

    // * 급여를 계산하는 메서드 (회계팀 클래스를 불러와 에서 사용)
    void calculatePay() {
        // ...
        new PayCalculator().calculatePay();
        // ...
    }

    // * 근무시간을 계산하는 메서드 (인사팀 클래스를 불러와 에서 사용)
    void reportHours() {
        // ...
        new HourReporter().reportHours();
        // ...
    }

    // * 변경된 정보를 DB에 저장하는 메서드 (기술팀 클래스를 불러와 에서 사용)
    void EmployeeSaver() {
        new EmployeeSaver().saveDatabase();
    }
}

// * 회계팀에서 사용되는 전용 클래스
class PayCalculator {
    // * 초과 근무 시간을 계산하는 메서드
    void calculateExtraHour() {
        // ...
    }
    void calculatePay() {
        // ...
        this.calculateExtraHour();
        // ...
    }
}

// * 인사팀에서 사용되는 전용 클래스
class HourReporter {
    // * 초과 근무 시간을 계산하는 메서드
    void calculateExtraHour() {
        // ...
    }
    void reportHours() {
        // ...
        this.calculateExtraHour();
        // ...
    }
}

// * 기술팀에서 사용되는 전용 클래스
class EmployeeSaver {

    void saveDatabase() {
        // ...
    }
}

// 각 책임에 맞게 잘 조율하여 클래스 분리만 잘 해놓는다면 SRP 는 다른 원리들에 비해 개념이 비교적 단순해 보인다.
// 왜냐하면 서버에 데이터를 보내는 동작과, 작업 결과를 파일에 기록하는 동작은 서로 관련된 동작이 아니기 때문이다.
//애초부터 EmployeeManagement 클래스는 CRUD를 담당하는 클래스로 설계 되어 있기 때문이다.
//단순히 성공/실패 결과를 로깅해주는 기능을 가미해서 더 안정적이게 클래스를 설계하였다고 보이겠지만, 하나의 책임에서 벗어난 결과가 되어 버린다.
//따라서 로깅(logging)만을 담당하는 클래스를 따로 분리하고, EmployeeManagement 클래스에서 합성(composition)Visit Website하여 사용하기만 하면 된다. 그러면 각기 서버에 전달하는 책임하고 로깅하는 단일 책임으로 나뉘어 구성된 객체를 만들 수 있게 된다.
//각 클래스가 변경해야 하는 이유는 단 하나뿐임을 기억하자
//출처: https://inpa.tistory.com/entry/OOP-💠-아주-쉽게-이해하는-SRP-단일-책임-원칙 [Inpa Dev 👨‍💻:티스토리]

class EmployeeManagement {
    Logger logger = new Logger(); // 합성

    // * Create 작업을 담당하는 CRUD 메소드
    void addEmployee(String employee) {
        if(Objects.equals(employee, "")) {
            postServer(employee); // 서버에 직원 정보를 보냄
            logger.logResult("[LOG] EMPLOYEE ADDED"); // 로그 출력
        } else {
            logger.logResult("[ERROR] NAME MUST NOT BE EMPTY");
        }
    }

    // * 서버에 데이터를 전달하는 메소드
    void postServer(String employees) {}
}

class Logger {
    // * 로그를 출력하는 매소드
    void logResult(String message) {
        System.out.println(message); // 로그를 콘솔에 출력
        writeToFile(message); // 로그 내용을 로그 파일에 저장
    }

    // * 파일에 내용을 저장하는 메소드
    void writeToFile(String msg){}
}
// 출처: https://inpa.tistory.com/entry/OOP-💠-아주-쉽게-이해하는-SRP-단일-책임-원칙 [Inpa Dev 👨‍💻:티스토리]
