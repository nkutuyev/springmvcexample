package com.phoenicia.fearfactor;

import com.phoenicia.fearfactor.entity.Continent;
import com.phoenicia.fearfactor.repository.ContinentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ImportResource("applicationContext.xml")
@EnableAutoConfiguration(exclude={HibernateJpaAutoConfiguration.class})
@ComponentScan
@EnableJpaRepositories
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        ContinentRepository repository = context.getBean(ContinentRepository.class);

        // save a couple of customers
        repository.save(new Continent("Europe"));
        repository.save(new Continent("Asia"));
        repository.save(new Continent("North America"));
        repository.save(new Continent("South America"));
        repository.save(new Continent("Africa"));
        repository.save(new Continent("Australia"));
    }

}
