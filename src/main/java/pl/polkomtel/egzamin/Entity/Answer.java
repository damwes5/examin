package pl.polkomtel.egzamin.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Answer {

    @Id
    @GeneratedValue
    Long id;

    private String value;

    private Boolean isCorrect;



}
