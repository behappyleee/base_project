package com.book.cleancode.chapter_6;

public class CleanCode_Object {

    // 변수를 private 으로 정의하는 이유는 남들이 변수에 의존하지 않게 만들고 싶어서이다.
    // 충동이든, 변덕이든 변수 타입이나 구현을 맘대로 바꾸고 싶어서다.
    // 그렇다면 왜 수 많은 프로그래머가 조회 get 이나 set 설정 함수를 당연히 public 으로 할 까 ... ?!
    // 변수 사이에 함수라는 계층을 넣는다고 구현이 저절로 감춰지지는 않는다. 구현을 감추려면 추상화가 필요하다 !

    // 자료를 세세하고 공개하기 보다는 추상적인 개념으로 표현하는 편이 더 좋다.
    // 개발자는 객체가 포함하는 자료를 표현할 가장 좋은 방법을 심각하게 고민하여야 한다.
    // 아무 생각 없이 조회/설정/함수를 추가하는 방법이 가장 나쁘다 !
    // 
}

// 구체적인 Point 클래스
class PointTest {
    public double x;
    public double y;
}

// 추상적인 Point 클래스
// 구체적인 클래스 보다는 조금 더 추상적인 PointerInterface 가 좋다
interface PointInterface {
    double getX();
    double getY();
    void setCartesian(double x, double y);
    double getR();
    double getTheta();
    void setPolar(double r, double theta);
}

// 구체적은 Vehicle interface
interface VehicleTest {
    double getFuelTankCapacityInGallons();
    double getGallonsOfGasoline();
}

// 추상적인 Vehicle interface
// 조금 더 추상 적인게 좋다.
interface VehicleTest2 {
    double getPercentFuelRemaining();
}

