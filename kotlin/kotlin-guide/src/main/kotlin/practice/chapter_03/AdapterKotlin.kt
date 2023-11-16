package practice.chapter_03

import java.util.stream.Stream

fun main() {

//    cellPhone(
//        charger(
//            usPowerOutlet()
//        ).toUsbTypeC()
//    )

    val l = listOf("a", "b", "c")
    streamProcessing(l.stream())

    val s = (Stream.generate{42}).toList()
    println(s)

}

fun <T> collectionProcessing(c: Collection<T>) {
    for(e in c) {
        println(e)
    }
}

fun <T> streamProcessing(stream: Stream<T>) {
    // Do something with stream !

}

fun UsbMini.toUsbTypeC() : UsbTypeC {
    val hasPower = this.hasPower == Power.TRUE
    return object : UsbTypeC {
        override val hasPower = hasPower
    }
}

// Power outlet exposes USPlug interface
fun usPowerOutlet(): USPlug {
    return object : USPlug {
        override val hasPower = 1
    }
}

// Charger accepts EUPlug interface and exposes UsbMini interface
fun charger(plug: EUPlug): UsbMini {
    return object : UsbMini {
        override val hasPower = Power.valueOf(plug.hasPower)
    }
}

fun cellPhone(chargeCable : UsbTypeC) {
    if(chargeCable.hasPower) {
        println("I've Got The Power !!")
    } else {
        println("No Power !!")
    }
}

interface USPlug {
    val hasPower: Int
}

interface EUPlug {
    val hasPower: String // "TRUE" or "FALSE"
}

interface UsbMini {
    val hasPower: Power
}

enum class Power {
    TRUE, FALSE
}

interface UsbTypeC {
    val hasPower: Boolean
}