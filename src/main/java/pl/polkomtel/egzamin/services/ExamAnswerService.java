package pl.polkomtel.egzamin.services;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.polkomtel.egzamin.Entity.ExamAnswer;
import pl.polkomtel.egzamin.repository.ExamAnswerRepository;

import java.util.List;
import java.util.Optional;

@Transactional
@Log
@AllArgsConstructor
@Service
public class ExamAnswerService {

    @NonNull
    private ExamAnswerRepository ExamAnswerRepository;

    public ExamAnswer add(ExamAnswer person) {
        return ExamAnswerRepository.save(person);
    }

    public List<ExamAnswer> getAll() {
        return ExamAnswerRepository.findAll();
    }

    public Optional<ExamAnswer> getById(Long id) {
        return ExamAnswerRepository.findById(id);
    }


}
