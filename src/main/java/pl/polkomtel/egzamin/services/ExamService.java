package pl.polkomtel.egzamin.services;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.java.Log;
import pl.polkomtel.egzamin.Entity.Exam;
import pl.polkomtel.egzamin.repository.ExamRepository;

import java.util.List;
import java.util.Optional;

@Log
@AllArgsConstructor
public class ExamService {

    @NonNull
    private ExamRepository examRepository;

    public Exam add(Exam person) {
        return examRepository.save(person);
    }

    public List<Exam> getAll() {
        return examRepository.findAll();
    }

    public Optional<Exam> getById(Long id) {
        return examRepository.findById(id);
    }


}
