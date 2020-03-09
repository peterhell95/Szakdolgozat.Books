package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.BookDTO;

public interface BookService {
    public List<BookDTO> getAllBook();

    public BookDTO getOneBook(Long id);

    public BookDTO createBook(BookDTO book);

    public BookDTO updateBook(BookDTO book);

    public BookDTO rateBook(Long id, Float rate);

    public boolean deleteBook(Long id);
}