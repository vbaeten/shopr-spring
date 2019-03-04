package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.Book;
import com.realdolmen.backend.dto.BookDto;

public class BookTestDataBuilder {

    public static Book.BookBuilder buildBookFictionBook() {
        return Book.builder().id(1L).title("A book").price(50).supplier("Dreamland").type("FictionBook").pages(30);
    }

    public static BookDto.BookDtoBuilder buildBookFictionBookDto() {
        return BookDto.builder().id(1L).title("A book").price(50).supplier("Dreamland").type("FictionBook").pages(30);
    }
}
