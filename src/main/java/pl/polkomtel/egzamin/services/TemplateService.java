package pl.polkomtel.egzamin.services;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.polkomtel.egzamin.Entity.Question;
import pl.polkomtel.egzamin.Entity.Template;
import pl.polkomtel.egzamin.repository.TemplateRepository;

import java.util.List;

@Transactional
@Log
@AllArgsConstructor
@Service
public class TemplateService {

    @NonNull
    private TemplateRepository templateRepository;

    @Transactional
    public Template getById(Long id) {
        return templateRepository.getOne(id);
    }

    public Template add(Template template) {
        return templateRepository.save(template);
    }

    public List<Template> getAll() {
        return templateRepository.findAll();
    }
    



}
