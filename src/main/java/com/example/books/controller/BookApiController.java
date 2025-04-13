package com.example.books.controller;

import com.example.books.dto.BookDto;
import com.example.books.service.BookServiceImpl;


import javax.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/books")
public class BookApiController  {
    private final BookServiceImpl bookService;

    @PostMapping
    public BookDto create(@Valid @RequestBody BookDto bookDto) {
        return bookService.create(bookDto);
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
