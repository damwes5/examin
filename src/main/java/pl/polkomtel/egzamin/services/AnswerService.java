package pl.polkomtel.egzamin.services;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.polkomtel.egzamin.Entity.Answer;
import pl.polkomtel.egzamin.repository.AnswerRepository;

import java.util.List;
import java.util.Optional;

@Transactional
@Log
@AllArgsConstructor
@Service
public class AnswerService {

    @NonNull
    private AnswerRepository answerRepository;

    public Answer add(Answer person) {
        return answerRepository.save(person);
    }

    public List<Answer> getAll() {
        return answerRepository.findAll();
    }

    public Optional<Answer> getById(Long id) {
        return answerRepository.findById(id);
    }


}
