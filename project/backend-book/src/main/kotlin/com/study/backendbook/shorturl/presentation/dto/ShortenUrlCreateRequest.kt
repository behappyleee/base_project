package com.study.backendbook.shorturl.presentation.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.URL

data class ShortenUrlCreateRequest(
    // Kotlin data class 에서 역직렬화를 할 때에는 JsonProperty 어노테이션 사용 or 기본 값 지정 등 기본 생성자 생성이 필요 !
    // 파라미터가 2개 이상 부터는 상관이 없음 !!
    @JsonProperty(namespace = "originalUrl")
    @NotBlank
    @URL(regexp = "[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)")
    val originalUrl: String,
)
