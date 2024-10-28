package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
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
