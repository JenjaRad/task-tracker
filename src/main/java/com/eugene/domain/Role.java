package com.eugene.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class Role extends AbstractEntity {

    @NotBlank(message = "Name cannot be null or blank")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Description cannot be blank")
    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "roles")
    @Singular
    private Set<User> users = new HashSet<>();

    @Builder
    public Role(String name, String description, Set<User> users) {
        this.name = name;
        this.description = description;
        this.users = users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }
}
