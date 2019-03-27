package com.realdolmen.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto extends BaseObjectDto {
    private Long userId;
    private String lastName;
    private String firstName;
    private String userName;
    private boolean admin;

    @lombok.Builder(builderClassName = "UserDtoBuilder")
    public UserDto(Long versionId, Long userId, String lastName, String firstName, String userName, boolean admin) {
        super(versionId);
        this.userId = userId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.userName = userName;
        this.admin = admin;
    }

    public static class UserDtoBuilder extends BaseObjectBuilder {
        UserDtoBuilder() {
            super();
        }
    }
}
