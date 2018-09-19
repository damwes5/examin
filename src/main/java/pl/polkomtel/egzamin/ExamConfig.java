package pl.polkomtel.egzamin;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.polkomtel.egzamin.repository.*;
import pl.polkomtel.egzamin.services.*;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

import static java.lang.Integer.parseInt;

@EnableJpaRepositories(basePackages = "pl.polkomtel.egzamin")
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
@EnableAspectJAutoProxy
@Configuration
public class ExamConfig {

    @Bean
    public QuestionService questionService(QuestionRepository questionRepository) {
        return new QuestionService(questionRepository);
    }

    @Bean
    public TemplateService templateService(TemplateRepository templateRepository) {
        return new TemplateService(templateRepository);
    }

    @Bean
    public ExamAnswerService examAnswerService(ExamAnswerRepository examAnswerRepository) {
        return new ExamAnswerService(examAnswerRepository);
    }

    @Bean
    public ExamService examService(ExamRepository examRepository) {
        return new ExamService(examRepository);
    }

    @Bean
    public AnswerService answerService(AnswerRepository answerRepository) {
        return new AnswerService(answerRepository);
    }

    @Bean
    public PersonService personService(PersonRepository personRepository) {
        return new PersonService(personRepository);
    }


    @Bean
    public DataSource dataSource(Environment environment) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername(environment.getProperty("database.username"));
        dataSource.setPassword(environment.getProperty("database.password"));
        dataSource.setJdbcUrl(environment.getProperty("database.url"));
        dataSource.setDriverClassName(environment.getProperty("database.driver"));
        dataSource.setMaximumPoolSize(parseInt(environment.getProperty("database.max-pool-size")));
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public PropertiesFactoryBean jpaProperties() {
        PropertiesFactoryBean factoryBean = new PropertiesFactoryBean();
        factoryBean.setLocation(new ClassPathResource("jpa.properties"));
        return factoryBean;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Properties jpaProperties) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("pl.polkomtel.egzamin");
        factoryBean.setJpaProperties(jpaProperties);
        factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        return factoryBean;
    }

}
