package pl.polkomtel.egzamin;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.polkomtel.egzamin.Entity.Answer;
import pl.polkomtel.egzamin.Entity.Person;
import pl.polkomtel.egzamin.Entity.Question;
import pl.polkomtel.egzamin.dictionary.GroupQuestion;
import pl.polkomtel.egzamin.services.*;

import java.util.HashSet;
import java.util.Set;

public class Egzaminator {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExamConfig.class)) {

            AnswerService answerService = context.getBean(AnswerService.class);
            ExamService examService = context.getBean(ExamService.class);
            ExamAnswerService examAnswerService = context.getBean(ExamAnswerService.class);
            PersonService personService = context.getBean(PersonService.class);
            QuestionService questionService = context.getBean(QuestionService.class);
            TemplateService templateService = context.getBean(TemplateService.class);

            // new Person
            personService.add(new Person("Grzegorz", "Brzenczyszczykiewicz"));
            personService.add(new Person("Stefan", "Karwowski"));

            System.out.println("All person: " + personService.getAll());


            // posilble answers for question 1
            Answer answerSpring = new Answer();
            answerSpring.setValue("Spring");
            answerSpring.setIsCorrect(true);


            Answer answerJpa = new Answer();
            answerJpa.setValue("Jpa");
            answerJpa.setIsCorrect(false);


            Set<Answer> answerSet = new HashSet<>();
            answerSet.add(answerJpa);
            answerSet.add(answerSpring);

            // question 1
            Question question = new Question();
            question.setValue("Który framwork lubisz najbardziej ?");
            question.setGroupQuestion(GroupQuestion.DEVELOPMENT);
            question.setAnswers(answerSet);
            question = questionService.add(question);

            System.out.println("Question saved: " + question);








        }
    }
}
