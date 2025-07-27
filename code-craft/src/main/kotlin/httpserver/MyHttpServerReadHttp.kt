package httpserver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.ServerSocket

fun main() {
    println("Server starting...")
    val httpServer = ServerSocket(4221)
    httpServer.reuseAddress = true

    val client = httpServer.accept()
    println("Accepted New Connection !")

    val input = BufferedReader(InputStreamReader(client.inputStream))
    val output = client.getOutputStream()

    // 1. 요청 라인 읽기 (예: "GET / HTTP/1.1")
    val requestLine = input.readLine()
    println("Request Line : $requestLine")

    // 2. 요청 헤더 읽기
    val headers = mutableMapOf<String, String>()
    var line: String?
    while (input.readLine().also { line = it } != null && line!!.isNotEmpty()) {
        val (key, value) = line.split(":", limit = 2)
        headers[key.trim()] = value.trim()
    }

    println("Headers: $headers")

    // 3. 바디 (Content-Length 기반 읽기)
    val contentLength = headers["Content-Length"]?.toIntOrNull() ?: 0
    val body = if (contentLength > 0) {
        val bodyChars = CharArray(contentLength)
        input.read(bodyChars, 0, contentLength)
        String(bodyChars)
    } else ""
    println("Body: $body")

    // 4. 간단한 응답 보내기
    val response = """
        HTTP/1.1 200 OK
        Content-Type: text/plain
        Content-Length: 2
        OK
    """.trimIndent()

    output.write(response.toByteArray())
    output.flush()

    client.close()
    println("Server stopped.")
}
