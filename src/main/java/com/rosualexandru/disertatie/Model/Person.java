package com.rosualexandru.disertatie.Model;


import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public abstract class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private int age;
}
