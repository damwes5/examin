package pl.polkomtel.egzamin.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Exam {
    @Id
    @GeneratedValue
    Long id;

    @OneToOne
    Template template;

    @OneToOne
    Person person;

    @OneToMany(mappedBy = "exam")
    Set<ExamAnswer> examAnswer = new HashSet<>();

}
