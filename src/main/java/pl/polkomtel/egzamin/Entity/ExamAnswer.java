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

    @OneToOne
    @JoinColumn(name = "exam")
    Exam exam;

    @OneToOne
    @JoinColumn(name = "question")
    Question question;

    @OneToOne
    @JoinColumn(name = "answer")
    Answer answer;

}
