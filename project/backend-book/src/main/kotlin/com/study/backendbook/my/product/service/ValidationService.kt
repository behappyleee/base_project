package com.study.backendbook.my.product.service

import jakarta.validation.Valid
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated

@Service
@Validated
open class ValidationService {
    open fun <T> checkValid(
        @Valid validationTarget: T,
    ) {
    }
}
