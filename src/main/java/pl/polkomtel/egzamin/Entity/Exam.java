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

    @ManyToOne
    @JoinColumn(name = "template")
    Template template;

    @ManyToOne
    @JoinColumn(name = "person")
    Person person;

    @OneToMany(mappedBy = "exam")
    Set<ExamAnswer> examAnswer = new HashSet<>();

}
