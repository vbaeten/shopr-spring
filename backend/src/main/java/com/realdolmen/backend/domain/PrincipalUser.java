package com.realdolmen.backend.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.security.Principal;
import java.util.Collection;

@Getter
@Setter
public class PrincipalUser implements Principal {
    private Long id;
    private String name;
    private Collection<? extends GrantedAuthority> roles;

    @Override
    public String getName() {
        return name;
    }

}
