package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.BookGenre;
import lombok.*;

@Getter
@Setter
@Builder(builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
public class FictionDto extends BookDto {

    private BookGenre bookGenre;
    private String synopsis;
}
