package com.realdolmen.backend.mapper;

import com.realdolmen.backend.data.BookTestDataBuilder;
import com.realdolmen.backend.domain.Book;
import com.realdolmen.backend.dto.BookDto;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BookMapperTest {

    private BookMapper bookMapper = Mappers.getMapper(BookMapper.class);

    @Test
    public void bookToUserDTO() throws Exception {
        Book book = BookTestDataBuilder.buildBookFictionBook().build();
        BookDto bookDto = bookMapper.bookToBookDto(book);

        assertEquals(book.getPrice(), bookDto.getPrice(), 0.05);
        assertEquals(book.getId(), bookDto.getId());
    }

    @Test
    public void bookDtoToBook() throws Exception {
        BookDto bookDto = BookTestDataBuilder.buildBookFictionBookDto().build();
        Book book = bookMapper.bookDtoToBook(bookDto);

        assertEquals(bookDto.getSupplier(), book.getSupplier());
        assertEquals(bookDto.getId(), book.getId());
    }

    @Test
    public void testBookShouldAssertNull() {
        Book book = bookMapper.bookDtoToBook(null);
        assertNull(book);
    }
    @Test
    public void testBookDtoShouldAssertNull() {
        BookDto bookDto = bookMapper.bookToBookDto(null);
        assertNull(bookDto);
    }
}
