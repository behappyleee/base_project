package com.board.back.test

import com.board.back.dto.Carts
import org.springframework.context.annotation.Bean
import org.springframework.http.ResponseEntity
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Bean
fun jsonSimple(): JsonSampleClient {
    val webClient = WebClient.builder().baseUrl("https://dummyjson.com").build()
    val httpServiceFactory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build()

    return httpServiceFactory.createClient(JsonSampleClient::class.java)
}

interface JsonSampleClient {

    @GetExchange("/carts")
    fun getData(): ResponseEntity<Carts>

}