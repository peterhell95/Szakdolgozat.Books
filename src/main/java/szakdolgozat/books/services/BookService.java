package szakdolgozat.books.services;

import java.util.List;

import szakdolgozat.books.dto.BookDTO;

public interface BookService {
    public List<BookDTO> getAllBook();

    public BookDTO getOneBook(Long id);

    public BookDTO createBook(BookDTO book);

    public BookDTO updateBook(BookDTO book);

    public boolean deleteBook(Long id);
}