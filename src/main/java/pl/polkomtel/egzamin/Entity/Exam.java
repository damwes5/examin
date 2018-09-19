package pl.polkomtel.egzamin.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Exam {
    @Id
    @GeneratedValue
    Long id;

    Template template;
    Person person;

    @OneToMany(mappedBy = "exam")
    Set<ExamAnswer> examAnswer = new HashSet<>();

}
