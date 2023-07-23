package com.test.springboot_test.domain;

import com.test.springboot_test.dummy.domain.Cat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CatTest {

    @Test
    public void testMeow() {
        String catName = "Stilla";
        int catAge = 3;
        boolean isNice = false;

        assertThat(catName, equalTo("Stilla"));
        assertThat(catAge, lessThan(5));
        assertThat(isNice, is(false));
    }

    // Cat 에 Class 인스턴스가 맞는 지 확인 !
    @Test
    public void testCatInstance() {
        Cat cat = new Cat();
        assertThat(cat, instanceOf(Cat.class));
    }

    // 객체가 서로 같은 객체인지 확인
    @Test
    public void testSameCatInstance() {
        Cat cat = new Cat();

        // 같은 Instance True 반환
        assertThat(cat, sameInstance(cat));

        // 다른 Instance False 반환
        Cat cat2 = new Cat();
        assertThat(cat2, sameInstance(cat));
    }

    @Test
    public void testCollectionContaining() {
        List<String> catNames = Arrays.asList("Phibi", "Monica", "Stilla");
        
        // 해당 Name 들을 포함하고 있는지 (다건)
        assertThat(catNames, hasItems("Monica", "Phibi"));
        // 해당 이름들을 포함하지 않고 있는 지 (Not - 부정)
        assertThat(catNames, not(hasItems("Test", "Another")));
        // 해당 이름을 포함 하고 있는 지 (단건)
        assertThat(catNames, hasItem("Stilla"));
    }

    @Test
    public void testCollectionSize() {
        List<String> catNames = Arrays.asList("Monica", "Julia", "Mary");
        
        // 해당 Collection 의 사이즈 확인
        assertThat(catNames, hasSize(3));
    }

    @Test
    public void testBean() {
        Cat cat = new Cat("Mimi");

        // 해당 객체의 Proprty 가 존재하는 지 확인 및 해당 Property 의 속성 이름으 Mimi 인지 확인
        assertThat(cat, hasProperty("name", equalTo("Mimi")));
    }

    @Test
    public void testStringEquality() {
        String catNameInCaps = "RACHEL";
        
        // 영어 알파벳의 대소문자 무시하고 String 값 비교
        assertThat(catNameInCaps, equalToIgnoringCase("rachel"));
    }

    @Test
    public void testStringContains() {
        String catName = "Joys the cute";

        assertThat(catName, containsString("cute"));
    }

}
