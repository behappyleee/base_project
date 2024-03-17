package com.book.cleancode.chapter7;

public class Exception_Clean {

    // 뭔가 잘 못 되면 바로 잡을 책임은 프로그래머에게 있다.
    // 꺠끗한 코드와 오류 처리는 확실한 연관성이 있다.
    // 상당 수 코드 기반은 전적으로 오류 처리 코드에 좌우가 된다.
    // 오류 코드 보다는 예외를 사용하라

    // 예외에서 프로그램 안에 다가 범위를 정의한다는 사실은 매우 흥미롭다.
    // 여러 해 동안 자바 프로그래머들은 확인된 예외의 장단점을 놓고 논쟁을 벌여왔다.
    // 예외에 의미를 제공하라, 예외를 던 질 때는 전 후 상황을 충분히 덧붙인다.

    // 어플리케이션에서 오류를 정의할 때 프로그래머에게 가장 중요한 관심사는 오류를 잡아내는 방법이 되어야 한다.


}

// 형편없이 예외 클래스를 설계한 경우
// 예외 클래스를 형편없이 짠 경우 발생할 것 같은 에러 케이스를 모두 다 잡는다.
//class PortConnect {
//    ACMEPort port = new ACMEPort(12);
//    try {
//        port.open();
//    } catch(DeviceException e) {
//        reportError(e);
//        logger.log("Device Error : {} ", e);
//    } catch(IllegalAccessException e) {
//        reportError(e);
//        logger.log("Illegal Exception : {} ", e)
//    } catch(ArithmeticException e) {
//        reportError(e);
//        logger.log("ArithemticException : {} ", e)
//    } finally {
//        checkFianlly();
//    }
//}

// ACMEPort 를 LocalClass 로 감싸면 훨씬 깔끔해 진다.
// LocalPort 클래스처럼 ACMEPort 를 감싸는 클래스는 매우 유용하다. 실제로 외부 APU 를 사용할 때는 감싸기 기법이 최선이다.

//class PortConnect {
//    LocalPort port = new LocalPort();
//
//    try {
//        port.open();
//    } catch(DeviceException e) {
//        reportError(e);
//        logger.log("Device Exception : {} ", e);
//    }
//
//}

//class LocalPort {
//    private ACMEPort innterPort;
//
//    public LocalPort(int portNumber) {
//        innterPort = new ACMEPort(portNumber);
//    }
//
//    public void open() {
//        //    try {
////        port.open();
////    } catch(DeviceException e) {
////        reportError(e);
////        logger.log("Device Error : {} ", e);
////          throw new DeviceException();
////    } catch(IllegalAccessException e) {
////        reportError(e);
////        logger.log("Illegal Exception : {} ", e)
////        throw new DeviceException();
////    } catch(ArithmeticException e) {
////        reportError(e);
////        logger.log("ArithemticException : {} ", e)
////        throw new DeviceException();
////    } finally {
////        checkFianlly();
////    }
//    }
//}