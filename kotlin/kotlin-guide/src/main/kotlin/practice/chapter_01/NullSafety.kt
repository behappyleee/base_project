package practice.chapter_01

fun main() {
    var willInitLater: String? = null

    // Error 가 발생
    // 받는 Paramter 가 NULL 허용이 안되기 때문에 에러가 발생
    // printLength(willInitLater)

}

// 받는 Parameter 가 null 이 아니면 에러가 발생
// 물음표가 없으면 NULL 을 허용하지 않음
fun printLength(s: String) {
    println(s.length)
}