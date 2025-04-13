package com.example.books.mappers;

import com.example.books.dto.BookDto;
import com.example.books.model.Book;

public class BookMapper {
    public static Book toModel(BookDto bookDto) {
        Book book = new Book();
        book.setBrand(bookDto.getBrand());
        book.setStock(bookDto.getStock());
        book.setTitle(bookDto.getTitle());
        book.setVendorCode(bookDto.getVendorCode());
        book.setYear(bookDto.getYear());
        book.setPrice(bookDto.getPrice());
        return book;
    }

    public static BookDto toDto(Book book) {
        return BookDto
                .builder()
                .id(book.getId())
                .brand(book.getBrand())
                .price(book.getPrice())
                .stock(book.getStock())
                .title(book.getTitle())
                .vendorCode(book.getVendorCode())
                .year(book.getYear())
                .build();

    }

}
