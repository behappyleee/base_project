package be.com.graphqldemo.model

data class Book(
    val id: String,
    val title: String,
    val genre: String,
    val authorId: String,
    val publisherId: String
)