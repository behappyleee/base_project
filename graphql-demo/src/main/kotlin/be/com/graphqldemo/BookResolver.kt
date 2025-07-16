package be.com.graphqldemo

import be.com.graphqldemo.model.Author
import be.com.graphqldemo.model.Book
import be.com.graphqldemo.model.Publisher
import be.com.graphqldemo.model.Review
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class BookResolver(
    private val bookService: BookService,
) {
    @QueryMapping
    fun books(): MutableList<Book> = bookService.findAllBooks()

    @QueryMapping
    fun bookByIdTest(@Argument id: String): Book? = bookService.findBookById(id)

    @SchemaMapping
    fun author(book: Book): Author? = bookService.findAuthorById(book.authorId)

    @SchemaMapping
    fun publisher(book: Book): Publisher? = bookService.findPublisherById(book.publisherId)

    @SchemaMapping
    fun reviews(book: Book): List<Review> = bookService.findReviewsByBookId(book.id)

    @MutationMapping
    fun addBook(
        @Argument title: String,
        @Argument genre: String,
        @Argument authorId: String,
        @Argument publisherId: String
    ): Book = bookService.addBook(title, genre, authorId, publisherId)

    @MutationMapping
    fun addReview(
        @Argument bookId: String,
        @Argument score: Int,
        @Argument comment: String?
    ): Review = bookService.addReview(bookId, score, comment)
}
