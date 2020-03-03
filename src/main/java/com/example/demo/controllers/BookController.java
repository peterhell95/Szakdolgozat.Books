package com.example.demo.controllers;

import com.example.demo.model.Book;
import com.example.demo.services.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookServiceImpl service;

    @GetMapping("/list")
    public List<Book> getAllBook(){
        return service.getAllBook();
    }

    @GetMapping("/list/{id}")
    public Book getBookById(@PathVariable Long id){
        return service.getOneBook(id);
    }

    @PostMapping("/add")
    public Book createBook(@RequestBody Book Book) {
        return service.createBook(Book);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book Book){
        return service.createBook(Book);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id){
        service.deleteBook(id);
    }
}