package pl.polkomtel.egzamin.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue
    Long id;
    String name;
    String lastName;

}
