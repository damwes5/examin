package pl.polkomtel.egzamin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polkomtel.egzamin.Entity.Answer;
import pl.polkomtel.egzamin.Entity.ExamAnswer;

public interface ExamAnswerRepository extends JpaRepository<ExamAnswer, Long> {
}
