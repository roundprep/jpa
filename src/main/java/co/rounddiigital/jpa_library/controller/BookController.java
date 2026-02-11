package co.rounddiigital.jpa_library.controller;

import co.rounddiigital.jpa_library.entity.Book;
import co.rounddiigital.jpa_library.model.ErrorResponse;
import co.rounddiigital.jpa_library.service.BookService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Books", description = "This is base for all book api")
@RestController
public class BookController {
    private BookService bookService;
    // Rest API  (What is good about ) - SOAP - Simple Object Access Protocol  ( API )
    // Software Systems since 1990
    //  C, C++, Fortran, Java, Visual Basic,.Net, RPG, Mainframe - There should be standard - Create a file -> Other system can load file
    //  This is not a standard ( Online - - SOAP (protocal to exchage information )
    //  Every SOAP Message will look  - Envelop -- Header, Message , XML
    // Chetan - App to provide snow cleaning services ( XML )
    // Ahan -- App to block driveway with snow  (JSON)
    // Zeel - create system which provide customer information
    // Content Negotiation
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/api/book", produces = {
            MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE
    } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "All Books",
                    content = @Content(schema = @Schema(implementation = Book.class))
            ),
            @ApiResponse(responseCode = "404", description = "No books found" ,
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )

    })
    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/api/book/{id}")
    public Optional<Book> finByIdBooks( @PathVariable Long id ) {
        return bookService.findBookById(id);
    }


    @PostMapping("/api/book")
    public Book saveBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("/api/book")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @GetMapping("/api/books")
    public List<Book> findBookByISBN(@RequestParam("desc") String description,
                                     @RequestParam(name = "isbn", required = false) String isbn) {
        if(null==isbn) {

        }
        return bookService.getBooks(description);
    }

    @DeleteMapping("/api/book/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

    @PostMapping("/api/books")
    public List<Book> createAllBooks(@RequestBody List<Book> books) {
        return bookService.createALlBooks(books);
    }

}
