package pl.polkomtel.egzamin;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.polkomtel.egzamin.Entity.*;
import pl.polkomtel.egzamin.dictionary.GroupQuestion;
import pl.polkomtel.egzamin.services.*;

import java.util.HashSet;
import java.util.Set;


public class Egzaminator {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExamConfig.class)) {

            //AnswerService answerService = context.getBean(AnswerService.class);
            //ExamAnswerService examAnswerService = context.getBean(ExamAnswerService.class);
            QuestionService questionService = context.getBean(QuestionService.class);
            ExamService examService = context.getBean(ExamService.class);

            TemplateService templateService = context.getBean(TemplateService.class);


            // add new person
            PersonService personService = context.getBean(PersonService.class);
            Person person1 = new Person("Grzegorz", "Brzenczyszczykiewicz");
            personService.add(person1);
            //System.out.println("Added person: " + personService.getAll());

            // create possible answers
            Answer answerSpring = new Answer();
            answerSpring.setValue("Spring");
            answerSpring.setIsCorrect(true);

            Answer answerJpa = new Answer();
            answerJpa.setValue("Jpa");
            answerJpa.setIsCorrect(false);

            Set<Answer> answerSet = new HashSet<>();
            answerSet.add(answerJpa);
            answerSet.add(answerSpring);

            // create question 1
            Question question = new Question();
            question.setValue("Który framwork lubisz najbardziej ?");
            question.setGroupQuestion(GroupQuestion.DEVELOPMENT);
            question.setAnswers(answerSet);

            //questionService.add(question);

            // add templete 1 with dependencies
            Template template = new Template();
            template.setName("Jezyki programowania");
            Set<Question> questions = new HashSet<>();
            questions.add(question);
            template.setQuestion(questions);
            template = templateService.add(template);

            // exam 2 begin - with set person, set templete with question and possible asnwer
            Exam exam = new Exam();
            exam.setPerson(person1);
            exam.setTemplate(template);

            exam = examService.add(exam);

            System.out.println("Exam started " + exam);


            // answer checked on the exam
            ExamAnswer examAnswer = new ExamAnswer();
            examAnswer.setAnswer(answerSpring);
            examAnswer.setQuestion(question);
            examAnswer.setExam(exam);

            Set<ExamAnswer> answerCheckedSet = new HashSet<>();
            answerCheckedSet.add(examAnswer);

            exam.setExamAnswer(answerCheckedSet);

            Exam endedExam = examService.update(exam);

            System.out.println("Exam ended with added answers" + endedExam);



        }
    }


}
