package pl.polkomtel.egzamin.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polkomtel.egzamin.Entity.Exam;
import pl.polkomtel.egzamin.UriBuilder;
import pl.polkomtel.egzamin.common.mapper.Mapper;
import pl.polkomtel.egzamin.services.ExamService;
import pl.polkomtel.egzamin.common.dto.ExamDto;
import pl.polkomtel.egzamin.services.PersonService;
import pl.polkomtel.egzamin.services.TemplateService;

import java.net.URI;


@RequestMapping("api/v/1/exams")
@RestController
@RequiredArgsConstructor
public class ExamController {

    @NonNull
    private ExamService examService;
    @NonNull
    private TemplateService templateService;
    @NonNull
    private PersonService personService;
    @NonNull
    private Mapper mapper;
    private UriBuilder uriBuilder = new UriBuilder();

    @PostMapping
    public ResponseEntity createExam(Long idPerson,  Long idTemplate) {
        System.out.println("test----------------------"+idPerson+" template "+idTemplate);
        Exam exam = new Exam();
        exam.setPerson(personService.getById(idPerson));
        exam.setTemplate(templateService.getById(idTemplate));
        exam = examService.add(exam);
        URI uri = uriBuilder.requestUriWithId(exam.getId());
        ExamDto accountDto = mapper.map(exam, ExamDto.class);
        return ResponseEntity.created(uri).body(accountDto);
    }

}
