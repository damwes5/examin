package pl.polkomtel.egzamin.services;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import pl.polkomtel.egzamin.Entity.Person;
import pl.polkomtel.egzamin.repository.PersonRepository;

import java.util.List;

@Log
@AllArgsConstructor
@Service
public class PersonService {

    @NonNull
    private PersonRepository personRepository;

    public Person add(Person person){
        return personRepository.save(person);
    }

    public List<Person> getAll(){
        return personRepository.findAll();
    }



}
