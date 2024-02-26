package com.book.cleancode.chpt_1;

import java.util.ArrayList;
import java.util.List;

public class NamingImportance {

    // 소프트웨어에서의 이름은 어디에서나 쓰인다, 우리는 변수에도 이름을 붙이고 함수에도 이름을 붙이고
    // 인스와 클래스와 패키지에도 이름을 붙이고 있다. 모든 곳에 이름을 붙이 고 있다
    // 이렇듯 많이 사용하므로 이름을 잘 지으면 여러모로 편하다.

    // 이름 Naming 을 잘 하는 법
    // 1. 의도를 분명히 밝혀라
    // 의도가 분명하게 이름을 지으라고 말하기는 쉽다. 의도가 분명한 이름이 정말로 중요하다는 사실을 거듭 강조


    // 그릇된 정보를 피하라 ! -> 프로그래머는 코드에 그릇된 단서를 남겨서는 안된다 ... !
    // 그릇된 단서는 코드 의미를 흐린다 ... !

    // 유사한 개념은 유사한 표기법을 사용한다. 이것도 정보다.
    // 의미 있게 구분하라. 컴파일러나 인터프리터만 통과하려는 생각으로 코드를 구현하는 프로그래머는 스스로 문제를 일으킨다.

    int d; // 경과 시간 (단위: 날짜)

    // 이름 d 는 아무것도 드러나지 않는다. 경과 시간이나 날짜라는 느낌이 안든다. 측청 하려는 값의 단위를 표현하는 이름이 필요

    int elapsedTimeInDays;
    int daysSinceCreation;
    int daysSinceModification;
    int fileAgeInDays;

    private final static int STATUS_VALUE = 0;
    private final static int FLAGGED = 3;

    public List<int[]> theList = new ArrayList<>();
    public List<int[]> gameBoard = new ArrayList<>();
    public List<Cell> gameBoardCell = new ArrayList<>();

    public NamingImportance() {
        int[] testA = {1,2,3};
        int[] testB = {1,2,3};
        theList.add(testA);
        theList.add(testB);

        gameBoard.add(testA);
        gameBoard.add(testB);
    }

    public List<int[]> getThem() {
        List<int[]> list1 = new ArrayList<int []>();

        // 코드가 하는 일 짐작이 어렵다. 문제는 코드의 단순성이 아니라 코드의 함축성이다. 다시 말해,
        // 코드 맥락이 코드 자체에 명시적으로 드러나지 않는다.

        // 1. theList 에 무엇이 들었는가 ?
        // 2. theList 에서 0 번 쨰 값이 왜 중요 한가 ... ?
        // 3. 값 4 는 무슨 의미 인가 ... ?
        // 4. 함수가 반환하는 list1 을 어떻게 사용하는가 ... ?
        for(int[] x: theList) {
            if(x[0] == 4) {
                list1.add(x);
            }
        }

        return list1;
    }

    // 위에 함수를 조금 더 쉽게 바꾸어 본다
    // 사실 theList 는 gameBoard 였다. 게임판에서 각 칸은 단순 배열로 표현한다. 배열에서 0 번쨰 값은 칸 상태를 뜻한다.
    // 값 4는 깃발이 꽃힌 상태를 가리킨다. 각 개념에 이름만 붙여도 코드가 상당히 나아진다.
    public List<int[]> getFlaggedCells() {
        List<int[]> flaggedCells = new ArrayList<int[]>();
        for(int[] cell: gameBoard) {
            if (cell[STATUS_VALUE] == FLAGGED) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }

    // int[] 라는 타입 대신 Cell 이라는 클래스를 만들어서도 사용이 가능 하다 !
    public List<Cell> getFlaggedCells2() {
        List<Cell> flaggedCells = new ArrayList<Cell>();

        for (Cell cell: gameBoardCell) {
            if (cell.isFlagged()) {
                flaggedCells.add(cell);
            }
        }

        return flaggedCells;
    }

    // a1 / a2 라는 이름대신 source / destination 으로 변수명을 사용한다면 코드 읽기가 훨씬 쉬워질 것이다.
    public static void copyChars(char a1[], char a2[]) {
        for(int i=0; i < a1.length; i++) {
            a2[i] = a1[i];
        }
    }

}

class Cell {

    public boolean isFlagged() {
        return true;
    }

}


