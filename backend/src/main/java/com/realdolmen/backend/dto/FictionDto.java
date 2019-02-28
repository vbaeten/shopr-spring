package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.BookGenre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FictionDto extends BookDto {

    private BookGenre bookGenre;
    private String synopsis;
}
