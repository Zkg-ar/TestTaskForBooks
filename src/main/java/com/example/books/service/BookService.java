package com.example.books.service;

import com.example.books.dto.BookDto;
import com.example.books.model.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    BookDto create(BookDto bookDto);

    Page<BookDto> getAllBooks(Integer from, Integer size);

    void deleteById(Long id);

    BookDto update(BookDto bookDto, Long id);

    BookDto getById(Long id);

}
