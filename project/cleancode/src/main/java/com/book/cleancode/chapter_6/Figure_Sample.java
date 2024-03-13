package com.book.cleancode.chapter_6;

public class Figure_Sample {

}
class Square {
    public PointTest topLeft;
    public double side;
}

class Rectangle {
    public PointTest topLeft;
    public double height;
    public double width;
}

class Circle {
    public PointTest center;
    public double radius;
}

class Geometry {
    public final double PI = 3.14159265;

    // 객체 지향 프로그래머가 해당 코드를 보면 클래스가 절차적이라 비판할 것이다.
    // 노련한 객체 지향 설계자는 VISITOR 혹인 Dual Patch 등과 같이 잘 알려진 기법을 사용하여 이 문제를 해결한다.
    // 하지만 이들 기법 역시 대가가 따르며 절차적인 프로그램에서 볼 수 있는 구조를 따른다 ... !

    // area 는 다형적 Polymorphic 메서드이다.
    public double area(Object shape) throws Exception {
        if(shape instanceof Square) {
            Square s = (Square) shape;
            return s.side * s.side;
        } else if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            return r.height * r.width;
        } else if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            return PI * c.radius * c.radius;
        }
        throw new Exception("No Such Shape Exception !");
    }
}

// 다형적인 도형
// 조금 더 객체 지향 설계적인 코드 적용 !
// 절차적인 코드는 기존 자료 구조를 변경하지 않으면서 새 함수를 추가하기 쉽다.
// 반면 객체 지향적인 코드는 기존 함수를 변경하지 않으면서 새 클래스를 추가 하기도 쉽다.
// 다시 말해, 객체 지향 코드에서 어려운 변경은 절차 적인 코드에서 쉬우며 절차 적인 코드에서 어려운 변경은
// 객체 지향 코드에서 쉽다.
interface Shape {}

class Square_Clean implements Shape {
    private PointTest topLeft;
    private double side;

    public double area() {
        return side * side;
    }
}

class Rectangle_Clean implements Shape {
    private PointTest topLeft;
    private double height;
    private double width;

    public double area() {
        return height * width;
    }
}

class Circle_Cleam implements Shape {
    private PointTest center;
    private double radius;

    public final double PI = 3.141592653;

    public double area() {
        return PI * radius * radius;
    }
}


