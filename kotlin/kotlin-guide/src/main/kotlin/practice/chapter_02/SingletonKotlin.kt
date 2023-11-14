package practice.chapter_02

fun main() {

    Logger.log("THIS IS TEST LOGGER CHECK ~~ !!!")

    StrToPrintLog.printLog("TRY WRITE MESSAGE MSG")

}

object StrToPrintLog {
    fun printLog(msg: String) {
        println("PRING LOG STRING $msg")
    }
}

object Logger {
    init {
        println("[THIS IS LOGGER INIT METHOD]")

        // Initalization login goes here
    }

    fun log(message: String) {
        println("THIS IS TEST LOG MESSAGE : $message")
    }
}

class SingletonKotlin {
}