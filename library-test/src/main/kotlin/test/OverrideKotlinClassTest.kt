package test

class OverrideKotlinClassTest: OpenKotlinClassTest() {

    override fun openClassPrintTest() {
        println("[OVERRIDE KOTLIN CLASS TEST CHECK !!!]")
    }
}
