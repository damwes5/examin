package pl.polkomtel.egzamin.services;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.polkomtel.egzamin.Entity.Person;
import pl.polkomtel.egzamin.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Transactional
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

    @Transactional
    public Person getById(Long id){
        return personRepository.getOne(id);

    }



}
