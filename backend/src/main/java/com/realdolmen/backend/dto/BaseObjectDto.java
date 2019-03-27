package com.realdolmen.backend.dto;

import lombok.*;

@Getter
@Setter
@Builder(builderClassName = "BaseObjectBuilder")
@AllArgsConstructor
@NoArgsConstructor
public class BaseObjectDto {
    private Long versionId;
}
