package com.board.back

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class TestController {

    @Test
    fun test() {
        // True Test 코드
        var strSame = "Kotlin Test";
        Assertions.assertEquals(strSame, "Kotlin Test");

        var strNotSame = "Not Same";

    }

}