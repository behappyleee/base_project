package com.book.cleancode.chapter_9;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Stack_Class {

    // 응집도 Cohension
    // 클래스는 인스턴스 변수가 작아야 한다. 각 클래스 메서드는 클래스 인스턴스 변수를 하나 이상 사용해야 한다. 일반적으로 메서드가 변수를 더 많이 사용 할수록
    // 메서드와 클래스는 응집도가 더 높아진다.
    // 모든 인스턴스 변수를 메서드마다 사용하는 클래스는 응집도가 가장 높다.
    // 일반적으로 이처럼 응집도가 가장 높은 클래스는 가능하지도 바람직하지도 않다. 그렇지만 우리는 응집도가 높은 클래스를 선호한다.
    // 응집도가 높다는 말은 클래스에 속한 메서드와 변수가 서로 의존하며 논리적인 단위로 묶인다는 의미기 때문이다.
    
    
    // 함수를 작게, 매개변수 목록을 짥게 전략을 따르다 보면 떄떄로 몇몇 메서드만이
    // 사용하는 인스턴스 변수가 아주 많아진다. 이는 십중팔구 새로운 클래스로 쪼개야 한다는 신호다.
    // 응집도가 높아지도록 변수와 메서드를 적절히 분리해 새로운 클래스 2~3 개로 쪼개 준다.

    // 응집도를 유지하면 작은 클래스 여럿이 나온다.



}

// 응집도가 높은 Stack Class
class Stack_Clan {

    private int topOfStack = 0;

    List<Integer> elements = new LinkedList<Integer>();

    public int size() {
        return topOfStack;
    }

    public void push(int element) {
        topOfStack++;
        elements.add(element);
    }

    public int pop() throws Exception {
        if (topOfStack == 0) {
            throw new NoSuchElementException();
        }

        int element = elements.get(--topOfStack);
        elements.remove(topOfStack);
        return element;
    }
}

class TestChild {

    public void testPrint() {
        System.out.println("THIS IS TEST PRIN !!");
    }

}