package pl.polkomtel.egzamin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polkomtel.egzamin.Entity.Answer;
import pl.polkomtel.egzamin.Entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
