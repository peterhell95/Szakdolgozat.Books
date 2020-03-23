package szakdolgozat.books.services;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public List<BookDTO> getBooksByPrice(Integer filter, Integer filter2) {
        List<BookDTO> filteredList = Collections.<BookDTO>emptyList();
        if (filter == null || filter2 == null)
            return filteredList;

        filteredList = bookMapper.bookListToBookDTOList(repository.findAllByPriceBetween(filter, filter2));

        //Clear the same elements 
        Set<BookDTO> set = new HashSet<>(filteredList);
        filteredList.clear();
        filteredList.addAll(set);

        return filteredList;
    }

    public List<BookDTO> getBooksByRate(Integer filter, Integer filter2) {
        List<BookDTO> filteredList = Collections.<BookDTO>emptyList();
        if (filter == null || filter2 == null)
            return filteredList;

        /*filteredList = bookMapper.bookListToBookDTOList(repository.findAllByRealrateBetween(filter, filter2));
        
        //Clear the same elements 
        Set<BookDTO> set = new HashSet<>(filteredList);
        filteredList.clear();
        filteredList.addAll(set);*/

        return filteredList;
    }

    public List<BookDTO> getBooksByName(String filter) {
        if (filter.isEmpty())
            return bookMapper.bookListToBookDTOList(repository.findAll());

        List<BookDTO> filteredList = bookMapper.bookListToBookDTOList(repository.findAllByTitleContaining(filter));
        filteredList.addAll(bookMapper.bookListToBookDTOList(repository.findAllByAuthorContaining(filter)));

        //Clear the same elements 
        Set<BookDTO> set = new HashSet<>(filteredList);
        filteredList.clear();
        filteredList.addAll(set);

        return filteredList;
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