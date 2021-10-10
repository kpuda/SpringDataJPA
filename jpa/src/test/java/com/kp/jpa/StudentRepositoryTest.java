package com.kp.jpa;

import com.kp.jpa.Repository.StudentRepository;
import com.kp.jpa.entity.Guardian;
import com.kp.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student= Student.builder()
                .emailId("kp@gmail.com")
                .firstName("kp")
                .lastName("pk")
                //.guardianName("KKPP")
                //.guardianEmail("KKPP@kpkp.com")
                //.guardianMobile("2131414124")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian= Guardian.builder()
                .email("anna@gmail.com")
                .mobile("1111111111")
                .name("Anna")
                .build();

        Student student=Student.builder()
        .emailId("anna@gmail.com")
        .firstName("Anna")
        .lastName("Bergsen")
        .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList=
                studentRepository.findAll();
        System.out.println("studentList "+ studentList);
    }
}
