package szakdolgozat.books.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import szakdolgozat.books.model.Book;

@Repository("BookRepository")
public interface BookRepository extends JpaRepository<Book, String> {

    Optional<Book> findById(Long id);

    void deleteById(Long id);

}