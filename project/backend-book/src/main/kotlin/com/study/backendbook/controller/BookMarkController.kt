package com.study.backendbook.controller

import com.study.backendbook.controller.dto.BookMark
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookMarkController {

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
        return bookmarks;
    }
}
