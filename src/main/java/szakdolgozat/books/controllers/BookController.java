package szakdolgozat.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import szakdolgozat.books.dto.BookDTO;
import szakdolgozat.books.services.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/list")
    public List<BookDTO> getAllBook() {
        return service.getAllBook();
    }

    @GetMapping("/searchByName")
    public List<BookDTO> getBooksByName(@RequestParam(value = "filter") String filter) {

        return service.getBooksByName(filter);
    }

    @GetMapping("/searchByPrice")
    public List<BookDTO> getBooksByPrice(@RequestParam(value = "filter") Integer filter, @RequestParam(value = "filter2") Integer filter2) {

        return service.getBooksByPrice(filter, filter2);
    }

    @GetMapping("/searchByRate")
    public List<BookDTO> getBooksByRate(@RequestParam(value = "filter") Integer filter, @RequestParam(value = "filter2") Integer filter2) {

        return service.getBooksByRate(filter, filter2);
    }

    @GetMapping("/list/{id}")
    public BookDTO getBookById(@PathVariable Long id) {
        return service.getOneBook(id);
    }

    @PostMapping("/add")
    public BookDTO createBook(@RequestBody BookDTO book) {
        return service.createBook(book);
    }

    @PutMapping("/update")
    public BookDTO updateBook(@RequestBody BookDTO book) {
        return service.updateBook(book);
    }

    @PutMapping("/{id}/rate/{rate}")
    public BookDTO rateBook(@PathVariable Long id, @PathVariable Float rate) {
        return service.rateBook(id, rate);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
    }
}