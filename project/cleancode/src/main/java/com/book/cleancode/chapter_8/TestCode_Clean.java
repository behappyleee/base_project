package com.book.cleancode.chapter_8;

public class TestCode_Clean {

    // 테스트 코드를 깨끗하게 유지하지 않으면 결국은 잃어버린다.
    // 그리고 테스트 케이스가 없으면 실제 코드를 유연하게 만드는 버팀목도 사라진다.
    // 아키텍처가 아무리 유연하더라도 설계를 아무리 잘 나눴더라도 테스트 케이스가 없으면 개발자는 변경을 주저한다.
    // 테스트 코드가 지저분하면 코드를 변경하는 능력이 떨어지며 코드 구조를 개선하는 능력도 떨어진다.
    // 테스트 코드가 지저분 할수록 실제 코드도 지저분해진다. 결국 테스트 코드를 잃어버리고 실제 코드도 망가진다.
    // 깨끗한 테스트 코드를 만드려면 세가지가 필요하다. 가독성, 가독성, 가독성이다.


}

// Test 코드 예제이다. FitNess 테스트 코드이며 테스트 코드가 너무 어렵게 되어 있어 개선의 여지가 충분하다.
// PathParser 는 문자열을 pagePath 인스턴스로 변환한다. pagePath 는 crawler 가 사용하는 객체이다.


//public void testGetPageHieratchyAsXml() throws Exception {
//    crawler.addPage(root, PathParser.parse("PageOne"));
//    crawler.addPage(root, PathParser.parse("PageOne.ChildOne"));
//    crawler.addPage(root, PathParser.parse("PageTwo"));
//
//    request.setResource("root");
//    request.addInput("type", "pages");
//    Responder responder = new SerializedPageResponder();
//    SimpleResponse response =
//            (SimpleResponse) responder.makeResponse(new FitNesseContext(root), request);
//    String xml = response.getContent();
//
//    assertEquals("text/xml", response.getContentType());
//    assertSubString("<name>PageOne</name>", xml);
//    assertSubString("<name>PageTwo</name>", xml);
//    assertSubString("<name>ChildOne</name>", xml);
//}
//
//public void testGetPageHieratchyAsXmlDoesntContainSymbolicLinks() throws Exception {
//    WikiPage pageOne = crawler.addPage(root, PathParser.parse("PageOne"));
//    crawler.addPage(root, PathParser.parse("PageOne.ChildOne"));
//    crawler.addPage(root, PathParser.parse("PageTwo"));
//
//    PageData data = pageOne.getData();
//    WikiPageProperties properties = data.getProperties();
//    WikiPageProperty symLinks = properties.set(SymbolicPage.PROPERTY_NAME);
//    symLinks.set("SymPage", "PageTwo");
//    pageOne.commit(data);
//
//    request.setResource("root");
//    request.addInput("type", "pages");
//    Responder responder = new SerializedPageResponder();
//    SimpleResponse response =
//            (SimpleResponse) responder.makeResponse(new FitNesseContext(root), request);
//    String xml = response.getContent();
//
//    assertEquals("text/xml", response.getContentType());
//    assertSubString("<name>PageOne</name>", xml);
//    assertSubString("<name>PageTwo</name>", xml);
//    assertSubString("<name>ChildOne</name>", xml);
//    assertNotSubString("SymPage", xml);
//}
//
//public void testGetDataAsHtml() throws Exception {
//    crawler.addPage(root, PathParser.parse("TestPageOne"), "test page");
//
//    request.setResource("TestPageOne"); request.addInput("type", "data");
//    Responder responder = new SerializedPageResponder();
//    SimpleResponse response =
//            (SimpleResponse) responder.makeResponse(new FitNesseContext(root), request);
//    String xml = response.getContent();
//
//    assertEquals("text/xml", response.getContentType());
//    assertSubString("test page", xml);
//    assertSubString("<Test", xml);
//}


// Refactoring 한 코드이다.
//public void testGetPageHierarchyAsXml() throws Exception {
//    makePages("PageOne", "PageOne.ChildOne", "PageTwo");
//
//    submitRequest("root", "type:pages");
//
//    assertResponseIsXML();
//    assertResponseContains(
//            "<name>PageOne</name>", "<name>PageTwo</name>", "<name>ChildOne</name>");
//}
//
//public void testSymbolicLinksAreNotInXmlPageHierarchy() throws Exception {
//    WikiPage page = makePage("PageOne");
//    makePages("PageOne.ChildOne", "PageTwo");
//
//    addLinkTo(page, "PageTwo", "SymPage");
//
//    submitRequest("root", "type:pages");
//
//    assertResponseIsXML();
//    assertResponseContains(
//            "<name>PageOne</name>", "<name>PageTwo</name>", "<name>ChildOne</name>");
//    assertResponseDoesNotContain("SymPage");
//}
//
//public void testGetDataAsXml() throws Exception {
//    makePageWithContent("TestPageOne", "test page");
//
//    submitRequest("TestPageOne", "type:data");
//
//    assertResponseIsXML();
//    assertResponseContains("test page", "<Test");
//}