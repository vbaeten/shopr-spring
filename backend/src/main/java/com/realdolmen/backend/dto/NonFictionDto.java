package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.Subject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NonFictionDto extends BookDto {

    private Subject subject;
}
