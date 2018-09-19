package pl.polkomtel.egzamin.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
@Data
public class Person {

    @Id
    @GeneratedValue
    Long id;

    String name;

    String lastName;

}
