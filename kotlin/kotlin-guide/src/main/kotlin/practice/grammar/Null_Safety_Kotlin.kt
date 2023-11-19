package practice.grammar

fun main(args: Array<String>) {

    // WAP to find out length of name
    // val name: String? = "Steve"

    val name: String? = null

    // 1, Safe Call ( ?.)
    // Returns the length if 'name' is not null else returns NULL
    // Use it if you don't mind getting NULL value
    println("The Length of name is 1 : ${name?.length}")

    // 2. Safe Call with let (?.let)
    // It executes the block ONLY IF name is NOT NULL
    name?.let {
        println("The Length of Name is 2 : ${name.length}")
    }

    // 3. Elvis Operator ( ?: )
    // When we have nullable reference 'name', we can say "is name is not null", use it,
    // otherwise use some non-null value"
    val len = if(name != null)
        name.length
    else
        -1

    val nameLen = name?.length ?: -1
    println("The Length Of Name Len Data : $nameLen")

    // 4. Non-Null assertion operator ( !! )
    // Use it when you are sure the value is NOT NULL
    // Throws NullPointerException if the value is found to be NULL
    println("The Length of name is : ${name!!.length}")

}