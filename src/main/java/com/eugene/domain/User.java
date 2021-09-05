package com.eugene.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class User extends AbstractEntity{

    @NotBlank(message = "Username cannot be null or empty")
    @Size(min = 5, max = 15, message = "Username must be in range of 5 and 15 characters")
    @Pattern(regexp = "^[A-Za-z_]\\w{4,14}$", message = "Please provide a valid username")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "First name cannot be null or empty")
    @Size(min = 2, max = 30, message = "First name must be in range of 2 and 30 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(min = 2,max = 30,message = "Last name must be in range of 2 and 30 characters")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty
    @Email(message = "Please provide a valid email")
    @Column(name = "email")
    private String email;

    @Pattern(regexp = "\\A(?=\\S*?[0-9])(?=\\S*?[a-z])(?=\\S*?[A-Z])(?=\\S*?[@#$%^&+=])\\S{8,}\\z",
            message = "Please provide a valid password that must be at least 8 characters, contain a digit and special symbol")
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    @Singular
    private Set<Role> roles = new HashSet<>();

    @Builder
    public User(Long id ,String username, String firstName, String lastName, String email, String password, Set<Role> roles) {
        super.setId(id);
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public void addRole(Role role){
        this.roles.add(role);
    }
}
