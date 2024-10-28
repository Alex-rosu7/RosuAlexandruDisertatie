package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Document("student")
public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = 3L;

    @Id
    private String id;

    @Field
    private Map<Long, List<Subject>> subjectsPerYear;

    @Field
    private Map<Subject, List<Double>> subjectGrades;


}
