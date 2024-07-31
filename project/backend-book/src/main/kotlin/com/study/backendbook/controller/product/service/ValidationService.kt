package com.study.backendbook.controller.product.service

import jakarta.validation.Valid
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated

@Service
@Validated
class ValidationService {

    fun <T> checkValid(@Valid T validationTarget) {
        // TODO - Validate 진행하는 코드 작성 필요 !
    }
}