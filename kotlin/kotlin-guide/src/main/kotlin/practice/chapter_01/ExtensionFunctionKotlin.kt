package practice.chapter_01

data class Password(val password: String) {
    fun hidePassword(): String = "*".repeat(password.length)
}

class ExtensionFunctionKotlin {

}

fun String.hideStringPassword(): String = "(".repeat(this.length)

fun String.changePasswordAndHide(password: String): String {
    println("CHANGE PASSWORD NEW VALUE : " + password)

    return "7".repeat(password.length)
}


fun main() {

    val password: String = "this is test password"
    println("PASSWORD SECURITY : ${password.hideStringPassword()}")

    var passwordData = Password("CHECKPASS")
    println("PASSWORD ENCRYPT : " + passwordData.hidePassword())

    var testPass: String = "aaaa"
    var changePassword: String = testPass.changePasswordAndHide("BBBBBBBBBBBBBB");

    println("NEW CHANGE PASSWORD : " + changePassword)

}