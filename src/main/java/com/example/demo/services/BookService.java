package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Book;

public interface BookService {
    public List<Book> getAllBook();

    public Book getOneBook(Long id);

    public Book createBook(Book book);

    public boolean deleteBook(Long id);
}