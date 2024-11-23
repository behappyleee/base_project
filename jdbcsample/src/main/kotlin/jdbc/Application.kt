package jdbc

import java.sql.DriverManager

class Application {

}

fun main() {
    val url = "jdbc:mysql://localhost:3306/test_jdbc"
    val userName = "root"
    val password = "1234"

    try {
        val connection = DriverManager.getConnection(url, userName, password)

        try {
            val sql = "INSERT INTO ACCOUNT (id, username, password) VALUES (1, \"lee\", 1234);"
            val statement = connection.prepareStatement(sql)

            statement.execute()
        } catch (exception: Exception) {
            println(exception)
        }

        print("Connection Data ${connection.metaData.url}")
        println("Connection Meta Data ${connection.metaData.schemas}")
        println("Connection Alive Status ${connection.isClosed}")
        println("Connection Info : $connection")
    } catch (exception: Exception) {
        println(exception)
    }
}