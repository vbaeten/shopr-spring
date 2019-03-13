package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.Subject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NonFictionDto extends BookDto {

    private Subject subject;

    @lombok.Builder(builderClassName = "NonFictionDtoBuilder")
    public NonFictionDto(Long id, String title, double price, String supplier, String type, String author, String isbn, int pages, Subject subject) {
        super(id, title, price, supplier, type, author, isbn, pages);
        this.subject = subject;
    }


    public static class NonFictionDtoBuilder extends BookDtoBuilder {
        NonFictionDtoBuilder() {super();}
    }
}
