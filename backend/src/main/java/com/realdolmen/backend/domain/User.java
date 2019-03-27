package com.realdolmen.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Setter
@Entity
public class User extends BaseObject {

    @Id
    @GeneratedValue
    private Long userId;

    private String lastName;

    private String firstName;
    @Column(unique = true)
    @Size(max = 50)
    private String userName;

    private boolean admin;

    @lombok.Builder(builderClassName = "UserBuilder")
    public User(Long versionId, Long userId, String lastName, String firstName, String userName, boolean admin) {
        super(versionId);
        this.userId = userId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.userName = userName;
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return admin == user.admin &&
                Objects.equals(userId, user.userId) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userId, lastName, firstName, userName, admin);
    }

    public static class UserBuilder extends BaseObjectBuilder {
        UserBuilder() {
            super();
        }
    }
}
