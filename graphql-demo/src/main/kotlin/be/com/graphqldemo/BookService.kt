package be.com.graphqldemo

import be.com.graphqldemo.model.Author
import be.com.graphqldemo.model.Book
import be.com.graphqldemo.model.Publisher
import be.com.graphqldemo.model.Review
import org.springframework.stereotype.Service

@Service
class BookService {

    private val authors = mutableListOf(
        Author("a1", "J.K. Rowling", "UK"),
        Author("a2", "Haruki Murakami", "Japan")
    )
    private val publishers = mutableListOf(
        Publisher("p1", "Bloomsbury"),
        Publisher("p2", "Kodansha")
    )
    private val books = mutableListOf(
        Book("b1", "Harry Potter", "Fantasy", "a1", "p1"),
        Book("b2", "Kafka on the Shore", "Fiction", "a2", "p2")
    )
    private val reviews = mutableListOf(
        Review("r1", "b1", 5, "Amazing!"),
        Review("r2", "b1", 4, "Really good."),
        Review("r3", "b2", 5, "Mind-blowing."),
    )

    fun findAllBooks(): MutableList<Book> {
        return books
    }
    fun findBookById(id: String) = books.find {
        it.id == id
    }

    fun findAuthorById(id: String) = authors.find {
        it.id == id
    }

    fun findPublisherById(id: String) = publishers.find {
        it.id == id
    }

    fun findReviewsByBookId(bookId: String) = reviews.filter {
        it.bookId == bookId
    }

    fun addBook(title: String, genre: String, authorId: String, publisherId: String): Book {
        val id = "b${books.size + 1}"
        val book = Book(id, title, genre, authorId, publisherId)
        books.add(book)
        return book
    }

    fun addReview(bookId: String, score: Int, comment: String?): Review {
        val id = "r${reviews.size + 1}"
        val review = Review(id, bookId, score, comment ?: "")
        reviews.add(review)
        return review
    }
}
