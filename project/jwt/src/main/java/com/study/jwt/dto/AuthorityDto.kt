package com.study.jwt.dto

import com.study.jwt.entity.Authority

data class AuthorityDto(
    var authorityName: String? = null
){
    companion object {
        fun from(authority: Authority): AuthorityDto {
            return authority.run {
                AuthorityDto(
                    authorityName = authorityName
                )
            }
        }
    }
}