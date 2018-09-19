package pl.polkomtel.egzamin;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.polkomtel.egzamin.Entity.Person;
import pl.polkomtel.egzamin.services.*;

public class Egzaminator {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExamConfig.class)) {

            AnswerService answerService = context.getBean(AnswerService.class);
            ExamService examService = context.getBean(ExamService.class);
            ExamAnswerService examAnswerService = context.getBean(ExamAnswerService.class);
            PersonService personService = context.getBean(PersonService.class);
            QuestionService questionService = context.getBean(QuestionService.class);
            TemplateService templateService = context.getBean(TemplateService.class);

            personService.add(new Person("Grzegorz", "Brzenczyszczykiewicz"));
            personService.add(new Person("Stefan", "Karwowski"));

            System.out.println("All person: " + personService.getAll());




        }
    }
}
