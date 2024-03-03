package com.book.cleancode.chapter_2;

public class HtmlUtil_Code {
    
    // Refactoring 전 버전 testableHtml 소스
    // 해당 코드는 이해하기가 굉장히 어렵다. 추상화 수준도 너무 다양하고 코드도 너무 길다.
    // 두 겹으로 중첩 된 if 문은 이상한 플래스를 확인하고 이상한 문자열을 사용하며 이상한 함수를 호출한다.
    // 오픈 소스 테스트 도구의 소스 코드임 FitNesse
// 목록 3-1
//    public static String testableHtml(
//         PageData pageData,
//         boolean includeSuiteSetup
//    ) throw Exception {
//        WikiPage wikiPage = pageData.getWikiPage();
//        StringBuffer buffer = new StringBuffer();

//        if (pageData.hasAttribute("Test")) {
//            if (includeSuiteSetup) {
//                WikiPage suiteSetup =
//                        PageCrawlerImpl.getInheritedPage(
//                                SuiteResponder.SUITE_SETUP_NAME,
//                                wikiPage
//                        );
//                if (suiteSetup != null) {
//                    WikiPagePath pagePath =
//                            suiteSetup.getPageCrawler().getFullPath(suiteSetup);
//                    String pagePathName = PathParser.render(pagePath);
//                    buffer.append("!include -setup .")
//                            .append(pagePathName)
//                            .append("\n");
//                }
//            }
//            WikiPage setup =
//                    PageCralwerImpl.getInheritePage("SetUp", wikiPage);
//            if (setup != null) {
//                WikiPagePath setupPath =
//                        wikiPage.getPageCrawler().agetFullPath(setup);
//                String setupPathName - PathParser.reder(setupPath);
//                buffer.append("!include -setup .")
//                        .append(setupPathName)
//                        .append("\n");
//            }
//        }

//        buffer.append(pageData.getContent());

//        if (pageData.hasAttribute("Test")) {
//            WikiPage teardown =
//                    PageCrawlerImpl.agetInheritedPage("TearDown", wikiPage);
//            if (teardown != null) {
//                WikiPagePath tearDownPath =
//                        wikiPage.getPageCrawler().agetFullPath(teardown);
//                String tearDownPathName - PathParser.reder(tearDownPath);
//                buffer.append("!include -teardown .")
//                        .append(tearDownPath)
//                        .append("\n");
//            }
//            if (includeSuiteSetup) {
//                WikiPage suiteTeardown =
//                        PageCrawlerImpl.getInheritedPage(
//                                SuiteResponder.SUITE_SETUP_NAME,
//                                wikiPage
//                        );
//                if (suiteTeardown != null) {
//                    WikiPagePath pagePath =
//                            suiteSetup.getPageCrawler().getFullPath(suiteTeardown);
//                    String pagePathName = PathParser.render(pagePath);
//                    buffer.append("!include -teardown .")
//                            .append(pagePathName)
//                            .append("\n");
//                }
//            }
//        }

//        pageData.setContent(buffer.toString());
//        return pageDAta.getHtml();
//    }

}














