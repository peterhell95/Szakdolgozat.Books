package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookDTO;
import com.example.demo.services.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/list")
    public List<BookDTO> getAllBook() {
        return service.getAllBook();
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
        return service.createBook(book);
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