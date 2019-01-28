package com.realdolmen.backend.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
public class UserDto {

    private Long id;
    private String firstName;
    private String name;

}
