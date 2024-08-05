package com.study.backendbook.controller.product.service

import jakarta.validation.Valid
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated

// TODO - open 안 붙이면 에러가 발생 원인 파악이 필요 !!
@Service
@Validated
open class ValidationService {

    fun <T> checkValid (@Valid validationTarget: T) {
        // TODO - Validate 진행하는 코드 작성 필요 !
        // do Nothing !
    }
}