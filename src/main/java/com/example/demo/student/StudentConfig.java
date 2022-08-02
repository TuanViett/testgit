package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.CommandLinePropertySource;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student DH = new  Student(
                    9L,"DH",
                    "KT@123.com",
                    LocalDate.of(2000,
                            Month.AUGUST,
                            8)

            );
            Student TT = new  Student(
                    28L,"TT",
                    "TT@123.com",
                    LocalDate.of(2001,
                            Month.JUNE,
                            28)
            );
            studentRepository.saveAll(
                    List.of(DH,TT)
            );
        };
    }
}
