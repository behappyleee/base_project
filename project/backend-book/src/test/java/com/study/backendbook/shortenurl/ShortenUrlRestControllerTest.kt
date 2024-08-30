package com.study.backendbook.shortenurl

import com.study.backendbook.shorturl.application.ShortenUrlService
import com.study.backendbook.shorturl.presentation.ShortenUrlRestController
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito.anyString
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.header
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import kotlin.reflect.KClass

@WebMvcTest(controllers = [ShortenUrlRestController::class])
class ShortenUrlRestControllerTest(
    @MockBean
    private val shortenUrlService: ShortenUrlService,
    @Autowired
    private val mockMvc: MockMvc,
) {
    @Test
    @DisplayName(value = "원래의 URL 로 리다이렉트가 되어야 한다.")
    fun redirectOriginalUrlTest() {
        val expectedOriginalUrl = "https://www.hanbit.co.kr"

        `when`(shortenUrlService.getOriginalUrlByShortenUrlKey(anyString()))
            .thenReturn(expectedOriginalUrl)

        mockMvc.perform(get("/any-key"))
            .andExpect(status().isMovedPermanently)
            .andExpect(header().string("Location", expectedOriginalUrl))
    }
}
