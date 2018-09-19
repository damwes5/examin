package pl.polkomtel.egzamin.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {

    @Id
    @GeneratedValue
    Long id;

    String name;

    String lastName;

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
