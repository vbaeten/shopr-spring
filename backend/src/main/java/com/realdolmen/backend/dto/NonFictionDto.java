package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NonFictionDto extends BookDto {

    private Subject subject;
}
