package com.rosualexandru.disertatie.Model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Document("teacher")
public class Teacher extends Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;
    @Id
    private String id;

    @Field
    private List<Subject> subject;
}
