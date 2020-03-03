package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    @Getter
    @Setter
    private BookRepository repository;

    public List<Book> getAllBook() {
        return repository.findAll();
    }

    public Book getOneBook(Long id) {
        return repository.findById(id).get();
    }

    public Book createBook(Book book) {
        return repository.save(book);
    }

    public boolean deleteBook(Long id) {
        repository.deleteById(id);
        return true;
    }
}