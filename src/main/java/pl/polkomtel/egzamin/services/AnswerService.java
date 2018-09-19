package pl.polkomtel.egzamin.services;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.java.Log;
import pl.polkomtel.egzamin.Entity.Answer;
import pl.polkomtel.egzamin.repository.AnswerRepository;

import java.util.List;
import java.util.Optional;

@Log
@AllArgsConstructor
public class AnswerService {

    @NonNull
    private AnswerRepository answerRepository;

    public Answer add(Answer person){
        return answerRepository.save(person);
    }

    public List<Answer> getAll(){
        return answerRepository.findAll();
    }

    public Optional<Answer> getById(Long id){
        return answerRepository.findById(id);
    }


}
