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
    @JoinColumn(name = "exam")
    Exam exam;

    @ManyToOne
    @JoinColumn(name = "question")
    Question question;

    @ManyToOne
    @JoinColumn(name = "answer")
    Answer answer;

}
