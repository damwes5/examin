package pl.polkomtel.egzamin.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import pl.polkomtel.egzamin.dictionary.GroupQuestion;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue
    Long id;

    String value;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "questionId")
    private Set<Answer> answers = new HashSet<>();

    GroupQuestion groupQuestion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question")
    private Template template;
}
