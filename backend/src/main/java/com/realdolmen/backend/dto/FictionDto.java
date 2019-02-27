package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.BookGenre;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FictionDto extends BookDto {

    private BookGenre bookGenre;
    private String synopsis;
}
