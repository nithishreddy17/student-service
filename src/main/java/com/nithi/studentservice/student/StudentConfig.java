package com.nithi.studentservice.student;

import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
   /* @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
                   Student nithish= new Student(
                            "Nithish",
                            25,
                            "nithish.musunur@gmail.com",
                            LocalDate.of(1996, SEPTEMBER,19)
                    );
            Student karthik= new Student(
                    "Karthik",
                    30,
                    "karthik.musunuru@gmail.com",
                    LocalDate.of(1990, JUNE,13)

            );

            repository.saveAll(
                    List.of(nithish,karthik)
            );
        };

    }*/
}
