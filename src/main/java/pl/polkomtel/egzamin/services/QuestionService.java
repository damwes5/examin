package pl.polkomtel.egzamin.services;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.java.Log;
import pl.polkomtel.egzamin.Entity.Question;
import pl.polkomtel.egzamin.repository.QuestionRepository;

import java.util.List;

@Log
@AllArgsConstructor
public class QuestionService {

    @NonNull
    private QuestionRepository questionRepository;

    public Question getById(Long id) {
        return questionRepository.getOne(id);
    }

    public Question add(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getAll() {
        return questionRepository.findAll();
    }




}
