package com.example.books.service;

import com.example.books.dto.BookDto;
import com.example.books.exceptions.NotFoundException;
import com.example.books.mappers.BookMapper;
import com.example.books.model.Book;
import com.example.books.notifications.NTFMessages;
import com.example.books.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookDto create(BookDto bookDto) {
        if (bookDto == null) {
            return null;
        }
        return BookMapper.toDto(bookRepository.save(BookMapper.toModel(bookDto)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookDto> getAllBooks(Integer from,Integer size) {
        Pageable page = PageRequest.of(from / size, size);
        return bookRepository
                .findAll(page)
                .stream()
                .map(BookMapper::toDto)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    @Override
    public BookDto update(BookDto bookDto, Long id) {
        if (bookDto.getId() == null) {
            bookDto.setId(id);
        }
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(NTFMessages.BOOK_NOT_FOUND.getMessage()));
        if (bookDto.getTitle() != null) {
            book.setTitle(bookDto.getTitle());
        }

        if (bookDto.getBrand() != null) {
            book.setBrand(bookDto.getBrand());
        }

        if (bookDto.getPrice() != null) {
            book.setPrice(bookDto.getPrice());
        }

        if (bookDto.getStock() != null) {
            book.setStock(bookDto.getStock());
        }

        if (bookDto.getVendorCode() != null) {
            book.setVendorCode(bookDto.getVendorCode());
        }

        if (bookDto.getYear() != null) {
            book.setYear(bookDto.getYear());
        }

        return BookMapper.toDto(bookRepository.save(book));
    }

    @SneakyThrows
    @Override
    @Transactional(readOnly = true)
    public BookDto getById(Long id) {
        Book book = bookRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(NTFMessages.BOOK_NOT_FOUND.getMessage()));
        return BookMapper.toDto(book);
    }

    @SneakyThrows
    @Override
    public void deleteById(Long id) {
        Book book = bookRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(NTFMessages.BOOK_NOT_FOUND.getMessage()));
        bookRepository.deleteById(id);
    }
}
