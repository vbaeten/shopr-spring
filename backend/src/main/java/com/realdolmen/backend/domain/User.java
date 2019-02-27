package com.realdolmen.backend.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Data
//@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content=JsonInclude.Include.NON_EMPTY)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false, unique = true)
    private String username;
//    @NotEmpty
    private String firstname;
//    @NotEmpty
    private String lastname;

    @Size(min = 4)
    private String password;

    @Column(name = "active")
    private boolean active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = true)
    private Cart cart;

    @OneToMany(mappedBy = "id")
    private List<Comment> comments;

    @OneToMany(mappedBy = "id")
    private List<FavoriteProduct> favoriteProducts;

}
