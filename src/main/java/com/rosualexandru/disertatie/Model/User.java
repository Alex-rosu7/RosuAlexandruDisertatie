package com.rosualexandru.disertatie.Model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Getter
@Setter
@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String username;
    private String password;
    private Set<String> roles; // Roles: ADMIN, STUDENT, TEACHER, PARENT

    public User() {
    }

    public User(String username, String password, Set<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

}
