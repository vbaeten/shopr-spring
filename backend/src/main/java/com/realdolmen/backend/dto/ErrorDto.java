package com.realdolmen.backend.dto;


import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class ErrorDto {
    private HttpStatus status;
    @Singular
    private List<String> messages;

}
