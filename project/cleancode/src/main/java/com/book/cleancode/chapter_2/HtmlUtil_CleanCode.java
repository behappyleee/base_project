package com.book.cleancode.chapter_2;

public class HtmlUtil_CleanCode {

    // HtmlUtil Refactoring 적용 Clean 코드 적용
    // 1. 작게 만들어라 ! --> 함수를 만드는 첫번째 규칙은 작게 만드는 것이다. 함수를 만드는 둘 쨰 규칙은 더 작게 만드는 것이다.
    // 2. 한가지만 해라 ! --> 목록 3-1 은 여러가지를 처리한다. 버퍼를 생성하고 페이지를 가져오고 경로를 렌더링하고
    //  불가사의한 문자열을 더하는 등 ... 반면 목록 3-3 은 한 가지만 처리한다. 설정 페이지와 해제 페이지를 테스트 페이지에 넣는다.
    // (함수는 한 가지를 해야한다. 그 한 가지를 잘해야 한다. 그 한 가지만을 잘 해야 한다.)
    // 3. 서술적인 이름을 사용하라 ! --> 좋은 이름이 주는 가치는 아무리 강조해도 지나치지 않는다. 가장 좋은 규칙은
    // 코드를 읽으면서 짐작했던 기능이 각 루틴이 그대로 수행 한다면 꺠끗한 코드라 불려도 좋다. 이름을 붙일 때는 일관성이 있어야 한다.

    // 하지만 3-3 에서 문제는 기능이 한가지만 하는지는 알기가 어렵다. 세가지를 한다고 주장할 수 도있다.
    // 1. 페이지가 테스트 페이지인지 판단한다.
    // 2. 그렇다면 설정 페이지와 해제 페이지를 넣는다.
    // 3. 페이지를 HTML 로 렌더링 한다.
    // 위에서 언급 하는 세 단계는 지정 된 함수 이름 아래에서 추상화 수준이 하나이다.
    // RenderPageWithSetupsAndTeardowns --> 페이지가 테스트 페이지인지 확인 한 후 테스트 페이지라면
    // 설정 페이지와 해제 페이지를 넣는다. 테스트 페이지든 아니든 페이지를 HTML 로 Rendering 한다.
    // 지정 된 함수 이름 아래에서 추상화 수준이 하나인 단계만 수행 한다면 그 함수는 한 가지 작업만 한다.
    // 어쩃거나 우리가 함수를 만드는 이유는 큰 개념을 (다시 말해, 함수 이름을) 다음 추상화 수준에서  여러 단계로
    // 나눠 수행하기 위함

    // 함수가 한 가지만 하는 지 판단하는 방법은 하나 더 있는데 단순히 다른 표현이 아니라 의미 있는 이름으로
    // 다른 함수를 추출이 가능 하다면 그 함수는 여러 작업을 하는 셈이다.
    // 코드는 위에서 아래로 이야기 처럼 읽혀야 좋다. 한 함수 다음에는 추상화 수준이 한 단계 낮은 함수가 온다.
    // 즉, 위에서 아래로 프로그램을 읽으면 함수 추상화 수준이 한 번에 한 단계씩 낮아진다.
    // 하지만 추상화 수준이 하나인 함수를 구현하기란 쉽지가 않다. 핵심은 짧으면서도 한 가지만 하는 함수이다.


//   목록 3-2
//    public static String renderPageWithSetupsAndTeardowns(
//        PageData pageData,
//        boolean isSuite
//    ) throws Exception {
//        boolean isTestPage = pageData.getWikiPage();
//        if (isTestPage) {
//            StringBuffer newPageContent = new StringBuffer();
//            includeSetupPages(testPage, newPageContent, isSuite);
//            newPageContent.append(pageData.getContent());
//            includeTeardownPages(testPage, newPageContent, isSuite);
//            pageData.setContent(newPageContent.toString());
//        }
//
//        return pageData.getHtml();
//    }

    // 해당 위에 Refactoring 된 함수도 굉장히 길다
    // 함수를 더 줄여 보았다. 다시 말해 if / else 문, while 문 등에 들어가는 블록은 한 줄이어야 한다는 의미
    // 대개 거기서 함수를 호출 한다. 그러면 바깥을 감싸는 함수가 작아질 뿐 아니라 블록 안에서 호출하는 함수 이름을
    // 적절히 짓는 다면 코드 이해가 정말 쉬워진다.
    // 추천 하는 것은 함수에서 함수 들여쓰기 수준은 1단이나 2단을 넘겨서는 안된다.

    // 함수 당 추상화 수준은 하나로 해야한다 !
    // 함수가 확실히 한 가지 작업만 하려면 함수 내 모든 문장의 추상화 수준이 동일하여야 한다.
//   목록 3-3
//    public static String renderPageWithSetupsAndTeardowns(
//        PageData pageData,
//        boolean isSuite
//    ) throws Exception {
//        if (isTestPage(pageData))
//            includeSetupAndTeardownPages(pageData, isSuite);

          // getHtml() 은 추상화 수준이 아주 높다. 한 함수 내에 추상화 수준을 섞으면 코드를 읽는 사람이 헷갈린다.
//        return pageData.getHtml();
//    }

}

