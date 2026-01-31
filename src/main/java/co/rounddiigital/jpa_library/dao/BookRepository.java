package co.rounddiigital.jpa_library.dao;

import co.rounddiigital.jpa_library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);

    List<Book> findAllByDescriptionContainingIgnoreCase(String description);
    @Query("SELECT b from Book b WHERE upper(b.description) LIKE upper(:description)")
    List<Book> findForLikeDesc(String description);

    @Query("select b from Book b, Author a where b.author.id = a.id and a.id is not null " )
    List<Book> findAllwihNoAuthor(String description);
}
