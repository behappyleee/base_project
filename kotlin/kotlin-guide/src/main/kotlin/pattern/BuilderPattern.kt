package pattern

import java.io.File
import java.util.jar.Attributes

// Builder 패턴

class Dialgo {

    fun setTitle(text: String) = println("[PRINT SET TITLE STRING : ${text}]")
    fun setTitleColor(color: String) = println("[PRINT SET TITLE COLOR : ${color}]")
    fun setMessage(text: String) = println("[PRINT SET MESSAGE TEXT : ${text}]")
    fun setMessageColor(text: String) = println("[PRINT SET MESSAGE COLOR : ${text}]")
    fun setImage(bitmapBytes: ByteArray) = println("[PRINT SET IMAGE BYTE ARRAY : ${bitmapBytes}]")

    fun show() = println("[SHOWING DIALOG THIS : ${this}]")

}

class DialogBuilder {

    private var titleHolder: String? = null
    private var messageHolder: String? = null
    private var imageHolder: File? = null


}

fun main() {




}

