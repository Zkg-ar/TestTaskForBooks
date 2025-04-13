package com.example.books.controller;

import com.example.books.dto.BookDto;
import com.example.books.service.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookServiceImpl bookService;
    @GetMapping("/api/books")
    public String getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {

        Page<BookDto> books = bookService.getAllBooks( page, size);
        model.addAttribute("books", books);

        return "booksPage";
    }
}
