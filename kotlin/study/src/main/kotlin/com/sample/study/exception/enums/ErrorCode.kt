package com.sample.study.exception.enums

enum class ErrorCode(
    val status: Int,
    val message: String,
) {

    RESOURCE_NOT_FOUND(401, "Resources Not Found From This Application"),
    INVALID_REQUSET(403, "This is Invalid Request Can't handle"),
    INTERNAL_SERVER_ERROR(502, "Happed Internal Server Error Please Check it !!")

}