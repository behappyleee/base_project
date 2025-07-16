package be.com.graphqldemo.model

data class Review(
    val id: String,
    val bookId: String,
    val score: Int,
    val comment: String
)