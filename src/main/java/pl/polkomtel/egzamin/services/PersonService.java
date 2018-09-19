package pl.polkomtel.egzamin.services;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.java.Log;
import pl.polkomtel.egzamin.Entity.Person;
import pl.polkomtel.egzamin.repository.PersonRepository;

import java.util.List;

@Log
@AllArgsConstructor
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
