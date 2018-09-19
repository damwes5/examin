package pl.polkomtel.egzamin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polkomtel.egzamin.Entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
