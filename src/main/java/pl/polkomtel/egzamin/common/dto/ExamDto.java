package pl.polkomtel.egzamin.common.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.polkomtel.egzamin.Entity.ExamAnswer;
import pl.polkomtel.egzamin.Entity.Person;
import pl.polkomtel.egzamin.Entity.Template;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
public class ExamDto {

    Long id;
    Template template;
    Person person;
    Set<ExamAnswer> examAnswer;

}
