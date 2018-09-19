package pl.polkomtel.egzamin.Entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@Data
public class Template {

    @Id
    @GeneratedValue
    Long id;

    String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "templateId")
    Set<Question> question = new HashSet<>();

}