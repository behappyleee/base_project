package httpserver

import java.net.ServerSocket

fun main(args: Array<String>) {
    println("Server starting...")
    val httpServer = ServerSocket(4221)
    httpServer.accept()
    println("Server stopped.")
}
