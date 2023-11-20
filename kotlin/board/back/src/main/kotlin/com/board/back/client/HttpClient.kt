package com.board.back.client

import org.springframework.web.service.annotation.GetExchange

// @HttpExchange("")
public interface HttpClient {

    @GetExchange("https://dummyjson.com/carts")
    fun getData(): Map<String,Object>;

}