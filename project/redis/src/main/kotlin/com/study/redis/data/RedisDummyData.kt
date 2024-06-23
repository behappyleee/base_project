package com.study.redis.data

import redis.clients.jedis.Jedis

class RedisDummyData {

}

fun main() {
    val jedis = Jedis("127.0.0.1", 6379)
    val pipeLine = jedis.pipelined()

    for (i in 1 .. 5) {
        val map = mapOf("TEST KEY" to "TEST VALUE")
        jedis.set("KEY$i", "VALUE$i")
        // pipeLine.zadd()
    }
    jedis.disconnect()
    // pipeLine.sync()
}
