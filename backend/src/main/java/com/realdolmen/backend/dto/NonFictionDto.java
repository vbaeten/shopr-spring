package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.Subject;
import lombok.*;

@Getter
@Setter
@Builder(builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
public class NonFictionDto extends BookDto {

    private Subject subject;
}
