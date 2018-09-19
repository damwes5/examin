package pl.polkomtel.egzamin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polkomtel.egzamin.Entity.Answer;

public interface AnswerRepository  extends JpaRepository<Answer, Long> {
}
