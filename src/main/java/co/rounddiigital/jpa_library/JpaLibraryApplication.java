package co.rounddiigital.jpa_library;

import co.rounddiigital.jpa_library.dao.BookRepository;
import co.rounddiigital.jpa_library.entity.Author;
import co.rounddiigital.jpa_library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaLibraryApplication {
    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaLibraryApplication.class, args);
    }
    
    @Bean
    CommandLineRunner init() {
        return agrs->{
           // List<Book> all = bookRepository.findAll();
           // all.stream().map(Book::getAuthor).forEach(System.out::println);

        };
    }
}
