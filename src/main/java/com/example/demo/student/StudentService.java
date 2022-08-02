package com.example.demo.student;

import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.Objects;

@Component
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("Email Taken ");
        }
        studentRepository.save(student);
    }

    public void deleteStudent (Long studentId){
        Boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student with id "+ studentId +"does not exists");
        }
        studentRepository.deleteById(studentId);
    }


    @Transactional
    public void updateStudent (Long studentId ,String name, String email){
        Student student= studentRepository.findById(studentId).orElseThrow(()
        -> new IllegalStateException("Student with id = "+ studentId  + " does not exists"));

        if (name != null && name.length()>0 && !student.getName().equals(name)){
            student.setName(name);
            studentRepository.save(student);
        }
        if (email != null && email.length() >0 && !student.getEmail().equals(email)){
            Optional <Student>  studentOptional= studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("Email Taken");
            }
            student.setEmail(email);
        }

    }
}
