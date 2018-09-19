package pl.polkomtel.egzamin.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ExamAnswer {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    @JoinColumn(name = "examAnswer")
    Exam exam;

    //@ManyToOne
    Question question;

    //@ManyToOne
    Answer answer;

}
