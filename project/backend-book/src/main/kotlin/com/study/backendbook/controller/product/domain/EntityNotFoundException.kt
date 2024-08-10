package com.study.backendbook.controller.product.domain

class EntityNotFoundException(
    private val errorMessage: String,
// RuntimeException 에 String 파라미터를 넣어주면 에러가 발생함 해결이 필요 ... !!
) : RuntimeException(errorMessage)

// 왜 exception 이 도메인 계층일까 ... ?!
// 엔티티를 찾지 못했을 때 발생하는 예외의 위치로는 도메인 계층이 더 자연 스럽다.
// 레이어드 아키텍처에서 모든 계층은 도메인 계층을 의존할 수 있으므로 모든 계층 에서 사용 되어야 할 EntityNotFouncException 은 도메인 계층에 위치시키는게 낫다.
