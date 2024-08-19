package com.study.backendbook.shorturl.domain

// TODO - Exception 모은 클래스들을 seald class 로 변경하는건 어떨까 ... ?!?!?!
class NotFoundShortenUrlException(message: String) : RuntimeException(message)