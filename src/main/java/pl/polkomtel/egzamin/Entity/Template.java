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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "templateId")
    Set<Question> question = new HashSet<>();

}