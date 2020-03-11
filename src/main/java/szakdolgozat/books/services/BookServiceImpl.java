package szakdolgozat.books.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Getter;
import lombok.Setter;
import szakdolgozat.books.dto.BookDTO;
import szakdolgozat.books.mapper.BookMapper;
import szakdolgozat.books.model.Book;
import szakdolgozat.books.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    @Getter
    @Setter
    private BookRepository repository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> getAllBook() {
        return bookMapper.bookListToBookDTOList(repository.findAll());
    }

    public BookDTO getOneBook(Long id) {
        return bookMapper.bookToBookDTO(repository.findById(id).get());
    }

    public BookDTO createBook(BookDTO book) {
        Book entity = bookMapper.bookDTOToBook(book);
        return bookMapper.bookToBookDTO(repository.save(entity));
    }

    public BookDTO updateBook(BookDTO book) {
        Book entity = bookMapper.bookDTOToBookUpdate(book);
        return bookMapper.bookToBookDTO(repository.save(entity));
    }

    public BookDTO rateBook(Long id, Float rate) {
        BookDTO book = getOneBook(id);
        book.setRatecount(book.getRatecount() + 1);
        book.setRate(rate + book.getRate());
        Book entity = bookMapper.bookDTOToBookUpdate(book);
        return bookMapper.bookToBookDTO(repository.save(entity));
    }

    public boolean deleteBook(Long id) {
        repository.deleteById(id);
        return true;
    }

}