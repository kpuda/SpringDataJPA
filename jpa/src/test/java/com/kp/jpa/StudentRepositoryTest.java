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
                .email("hg3fafgh@gmail.com")
                .mobile("21aad11111111")
                .name("fd1fss")
                .build();

        Student student=Student.builder()
        .emailId("pJg42dsg@gmail.com")
        .firstName("a3dsdPeter")
        .lastName("Ja32cwwkson")
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

    @Test
    public void printStudentByFirstName() {
        List<Student> studentList=
        studentRepository.findByFirstName("Anna");
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> studentList=
                studentRepository.findByFirstNameContaining("p");
        System.out.println(studentList);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> studentList =
                studentRepository.findByGuardianName("Anna");
        System.out.println("studentList = " + studentList);
    }

    /*@Test
    public void printGetStudentByEmailAddress(){
        Student student=
                studentRepository.getStudentByEmailAddress(
                        "pJg2dsg@gmail.com"
                );
        System.out.println("student = " + student);
    }*/

    /*@Test
    public void printGetStudentByEmailAddressNative(){
        Student student=
                studentRepository.getStudentByEmailAddressNative(
                        "pJg2dsg@gmail.com"
                );
        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeParam(){
        Student student=
                studentRepository.getStudentByEmailAddressNativeNamedParam(
                        "pJg2dsg@gmail.com"
                );
        System.out.println("student = " + student);
    }*/

    /*@Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId(
                "ayylmao",
                "pJgdsg@gmail.com");
    }*/
}
