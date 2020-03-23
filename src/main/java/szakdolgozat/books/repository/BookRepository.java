package szakdolgozat.books.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import szakdolgozat.books.model.Book;

@Repository("BookRepository")
public interface BookRepository extends JpaRepository<Book, String> {

    Optional<Book> findById(Long id);

    List<Book> findAllByTitleContaining(String filter);

    List<Book> findAllByAuthorContaining(String filter);

    List<Book> findAllByPriceBetween(Integer value1, Integer value2);

    //List<Book> findAllByRealrateBetween(Integer value1, Integer value2);

    void deleteById(Long id);

}