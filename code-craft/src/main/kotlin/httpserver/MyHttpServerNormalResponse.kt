package httpserver

import java.net.ServerSocket

fun main(args: Array<String>) {
    println("Server starting...")
    val httpServer = ServerSocket(4221)

    httpServer.reuseAddress = true
    val client = httpServer.accept()
    println("Accepted New Connection !")

    val clientInputStream = client.inputStream.read()
    println("Client received $client")

    val output = client.outputStream

    output.write("HTTP/1.1 200 OK This is Custom !\r\n\r\n".toByteArray())
    output.flush()

    output.close()
    client.close()
    println("Server stopped.")
}
