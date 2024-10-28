package com.rosualexandru.disertatie.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Document("person")
public class Parent extends Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 4L;
    @Id
    private String id;

    private List<Student> children;

}
