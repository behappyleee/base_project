package com.study.backendbook.my

import com.study.backendbook.my.dto.BookMark
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookMarkController {
    // 직렬화 Serialization 인스턴스 메모리 자바 객체 -> 문자열
    // 역 직렬 화 DeSerialization 문자열 -> 자바 객체

    // 메모리 상에 존재하는 인스턴스를 바이너리 형태나 문자열로 만드는 것 -> 직렬화 Serialization
    // 반대가 역 직렬화 Deserialization

    private val bookmarks = mutableListOf<BookMark>()

    @PostMapping("/bookmark")
    fun registerBookmark(
        @RequestBody bookmark: BookMark,
    ): String {
        bookmarks.add(bookmark)
        return "registered !"
    }

    // TODO
    // kotlin jackson config 확인이 필요 !!!
    // Response 시 그냥 빈 list 날라감 추가 확인이 필요 .... !!!
    @GetMapping("/bookmarks")
    fun getBookMarks(): List<BookMark> {
        return bookmarks
    }
}
