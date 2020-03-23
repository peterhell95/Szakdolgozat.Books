package szakdolgozat.books.services;

import java.util.List;

import szakdolgozat.books.dto.BookDTO;

public interface BookService {
    public List<BookDTO> getAllBook();

    public BookDTO getOneBook(Long id);

    public List<BookDTO> getBooksByName(String filter);

    public List<BookDTO> getBooksByPrice(Integer filter, Integer filter2);

    public List<BookDTO> getBooksByRate(Integer filter, Integer filter2);

    public BookDTO createBook(BookDTO book);

    public BookDTO updateBook(BookDTO book);

    public BookDTO rateBook(Long id, Float rate);

    public boolean deleteBook(Long id);
}