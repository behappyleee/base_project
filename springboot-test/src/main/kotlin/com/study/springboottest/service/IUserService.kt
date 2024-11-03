package com.study.springboottest.service

import com.study.springboottest.entity.User

interface IUserService {

    fun saveUser(user: User): Int

}