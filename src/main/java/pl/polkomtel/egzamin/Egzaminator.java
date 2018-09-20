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
            ExamAnswerService examAnswerService = context.getBean(ExamAnswerService.class);
            QuestionService questionService = context.getBean(QuestionService.class);
            ExamService examService = context.getBean(ExamService.class);

            TemplateService templateService = context.getBean(TemplateService.class);


            // add new person
            PersonService personService = context.getBean(PersonService.class);
            Person person1 = new Person("Grzegorz", "Brzenczyszczykiewicz");
            personService.add(person1);
            //System.out.println("Added person: " + personService.getAll());

            // create possible answers for question 1
            Answer answerSpring = new Answer();
            answerSpring.setValue("Spring");
            answerSpring.setIsCorrect(true);

            Answer answerJpa = new Answer();
            answerJpa.setValue("Jpa");
            answerJpa.setIsCorrect(false);

            Set<Answer> answerSet = new HashSet<>();
            answerSet.add(answerJpa);
            answerSet.add(answerSpring);

            // for question 2
            Answer answer1 = new Answer();
            answer1.setValue("Krowa");
            answer1.setIsCorrect(true);

            Answer answer2 = new Answer();
            answer2.setValue("Ryba");
            answer2.setIsCorrect(false);

            Answer answer3 = new Answer();
            answer3.setValue("Słoń");
            answer3.setIsCorrect(true);

            Set<Answer> answerSet2 = new HashSet<>();
            answerSet2.add(answer1);
            answerSet2.add(answer2);
            answerSet2.add(answer3);

            // create question 1
            Question question = new Question();
            question.setValue("Który framwork lubisz najbardziej ?");
            question.setGroupQuestion(GroupQuestion.DEVELOPMENT);
            question.setAnswers(answerSet);

            // create question 2
            Question question2 = new Question();
            question2.setValue("Które zwierze jest ssakiem?");
            question2.setGroupQuestion(GroupQuestion.ANIMALS);
            question2.setAnswers(answerSet2);

            //questionService.add(question);

            // add templete 1 with dependencies
            Template template = new Template();
            template.setName("Jezyki programowania");
            Set<Question> questions = new HashSet<>();
            questions.add(question);
            questions.add(question2);
            template.setQuestion(questions);
            template = templateService.add(template);

            // exam 2 begin - with set person, set templete with question and possible asnwer
            Exam exam = new Exam();
            exam.setPerson(person1);
            exam.setTemplate(template);

            exam = examService.add(exam);

            System.out.println("Exam start " + exam);


            // question 1 answer checked
            ExamAnswer examAnswer = new ExamAnswer();
            examAnswer.setAnswer(answerSpring);
            examAnswer.setQuestion(question);
            examAnswer.setExam(exam);

            // question 2 answer checked
            ExamAnswer examAnswer2 = new ExamAnswer();
            examAnswer2.setAnswer(answer1);
            examAnswer2.setQuestion(question2);
            examAnswer2.setExam(exam);

            // nie zaznaczono 2 poprawnej odpowiedzi wiec odpowiedz powinna zostac zakwalifikowana jako nie poprawna
            // chyba że odko

            /*
            // question 2 second answer checked

            ExamAnswer examAnswer3 = new ExamAnswer();
            examAnswer2.setAnswer(answer3);
            examAnswer2.setQuestion(question2);
            examAnswer2.setExam(exam);

            examAnswerService.add(examAnswer);
            */

            System.out.println("Add exam answer" + examAnswer);


        }
    }


}
