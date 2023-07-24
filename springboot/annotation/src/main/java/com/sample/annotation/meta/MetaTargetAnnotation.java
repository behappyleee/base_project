package com.sample.annotation.meta;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class MetaTargetAnnotation {

    /**
     * @Target -> Target 어노테이션은 해당 요소를 어디에 사용할 건지 지정이 가능하다 (ex) Class .. 라던지 ..)ㄴ
     *            ex) @Target(Element.TYPE) => 해당 Target 을 Element Type 으로 지정 시 해당 어노테이션은 메서드에는 사용이 불가하고
     *                클래스에만 사용이 가능하다
     *
     *  ElementType.ANNOTATION_TYPE
     *  ElementType.CONSTRUCTOR
     *  ElementType.FIELD
     *  ElementType.LOCAL_VARIABLE
     *  ElementType.METHOD
     *  ElementType.PACKAGE
     *  ElementType.PARAMETER
     *  ElementType.TYPE
     *
     * */

    public static void main(String[] args) {

    }

}

@Target(ElementType.TYPE)
@interface TargetTest {

}

@TargetTest
class MetaTest {

    // 해당 TargetTest 는 ElementType 을 TYPE 로 지정 하였기에 메서드에 사용 시 Error 가 발생 함 !
    // @TargetTest
    public void test() {

    }
}


