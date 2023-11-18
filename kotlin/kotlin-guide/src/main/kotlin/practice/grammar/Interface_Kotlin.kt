package practice.grammar

fun main() {
    val myButton = MyButton()

    myButton.onTouch()
    myButton.onClick()
}


interface MyInterfaceListener {

    fun onTouch()       // Method in interface are abstract by default

    fun onClick() {     // Normal methods are public and open by default but NOT FINAL
        println("MyInterfaceListener : onClick !")
    }
}

interface MySecondInterface {

    fun onTouch() {     // Normal Method
        println("MySecondInterface : onTouch")
    }

    fun onClick() {     // Normal Method are public and open by default but NOT FINAL
        println("MySecondInterface : onClick")
    }
}

class MyButton: MyInterfaceListener, MySecondInterface {

    override fun onTouch() {
        println("MyButton Override OnTouch Method !!!")
        super<MyInterfaceListener>.onClick()
        super<MySecondInterface>.onClick()
    }

    override fun onClick() {
        super.onTouch()
    }

}