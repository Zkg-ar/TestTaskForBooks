package com.example.books.controller;

import com.example.books.dto.BookDto;
import com.example.books.service.BookServiceImpl;


import javax.validation.Valid;
import javax.validation.constraints.Min;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/books")
public class BookController {
    private final BookServiceImpl bookService;

    @PostMapping
    public BookDto create(@Valid @RequestBody BookDto bookDto) {
        return bookService.create(bookDto);
    }

    @GetMapping()
    public List<BookDto> getAllBooks(@RequestParam(value = "from", defaultValue = "0") @Min(0) Integer from,
                                     @RequestParam(value = "size", defaultValue = "20") @Min(1) Integer size) {
        return bookService.getAllBooks(from, size);
    }

    @PutMapping("/{id}")
    public BookDto update(@Valid @RequestBody BookDto bookDto, @PathVariable Long id) {
        return bookService.update(bookDto, id);
    }

    @GetMapping("/{id}")
    public BookDto getById(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        bookService.deleteById(id);
    }


}
