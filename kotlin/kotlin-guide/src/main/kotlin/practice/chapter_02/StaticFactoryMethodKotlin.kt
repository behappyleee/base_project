package practice.chapter_02

fun main() {
    val server1 = Server.withPort(9090)

    println(server1)
}

class Server private constructor(port: Long) {
    init {
        println("Server started on port $port")
    }

    companion object {
        fun withPort(port: Long): Server {
            return Server(port)
        }
    }

}


class StaticFactoryMethodKotlin {
}