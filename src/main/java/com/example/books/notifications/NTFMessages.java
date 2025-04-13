package com.example.books.notifications;

import lombok.Getter;

@Getter
public enum NTFMessages {
    BOOK_NOT_FOUND("Книга с переданным идентификатором не найдена"),

    ;

    final String message;

    NTFMessages(String message) {
        this.message = message;
    }
}
