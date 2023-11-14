package practice.chapter_01

data class DataClassKotlin(
    var userName: String,
    private val password: String,
) {

    fun passwordLength(): Int = password.length

    fun execMethod(): String = "This is Data Class Method In Kotlin !"

}

fun main() {

    val dataKotlin = DataClassKotlin("data-name", "77773333")

    dataKotlin.userName;
    dataKotlin.passwordLength()

    // private 키워드라 접근이 불가
    // dataKotlin.password
    // 메서드만 접근이 가능
    dataKotlin.passwordLength()
}
