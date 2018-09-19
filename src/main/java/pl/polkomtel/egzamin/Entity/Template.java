package pl.polkomtel.egzamin.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Template {

    @Id
    @GeneratedValue
    Long id;

    @OneToMany(mappedBy = "template", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Question> question = new HashSet<>();


}