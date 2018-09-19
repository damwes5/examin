package pl.polkomtel.egzamin;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Egzaminator {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExamConfig.class)) {

        }
    }
}
