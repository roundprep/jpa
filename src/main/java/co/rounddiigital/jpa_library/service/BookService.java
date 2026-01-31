package co.rounddiigital.jpa_library.service;

import co.rounddiigital.jpa_library.dao.AuthorRepo;
import co.rounddiigital.jpa_library.dao.BookRepository;
import co.rounddiigital.jpa_library.entity.Author;
import co.rounddiigital.jpa_library.entity.Book;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;
    private AuthorRepo authorRepo;

    public BookService(BookRepository bookRepository, AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        book.setCreateDate(new Date());
        book.setPublishDate(new Date());
//        Author author = book.getAuthor();
//        author = authorRepo.save(author); // this generates ID
//        book.setAuthor(author); // Added author with id

        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAllBooks() {
        List<Book> all = bookRepository.findAll();
        System.out.println("All books: " + all);
        return all;
    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public Optional<Book> findBookByISBN(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }


    public List<Book> createALlBooks(List<Book> books) {
            return bookRepository.saveAll(books);
    }

    public List<Book> getBooks(String description) {
        return bookRepository.findAllByDescriptionContainingIgnoreCase(description);
    }
}
