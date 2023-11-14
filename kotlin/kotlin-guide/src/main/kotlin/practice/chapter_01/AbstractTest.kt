package practice.chapter_01


class AbstractExtends(): AbstractTest() {

    override fun testFun() {
        println("JUST OVERRIDE !!!")
    }

}

abstract class AbstractTest() {

    protected var x: Int = 0

    protected var y: Int = 0

    // 자바에서는 class 에 final 이 붙지 않으면 상속이 무조건 가능하였지만
    // 코트린에서는 클래스와 메서드는 기본적으로 final 임 어떤 클래스의 상속을 허용 하려면 해당 클래스 앞에
    // open 변경자를 붙여야 함 오버 라이드를 허용하고 싶은 메서드나 프로퍼티 앞에도 open 변경자를 붙여야 함
    
    // Method 앞에 open 이 붙어 있어 Override 가 가능
    open fun move(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    // 하위 클래스에서 override 불 가능
    fun testFunc(): String {
        return "This is not override method !"
    }

    // 추상화 클래스의 미구현 메서드는 abstract 키워드를 붙여주어야 함
    abstract fun testFun()

    fun position() = "$x + $y"

}