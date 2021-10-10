package com.kp.jpa.Repository;

import com.kp.jpa.entity.Course;
import com.kp.jpa.entity.Student;
import com.kp.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Test
    public void printCourses(){
        List<Course> courses=
                repository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher=Teacher.builder()
                .firstName("James")
                .lastName("Killigan")
                .build();

        Course course=Course.builder()
                .title("Python")
                .credit(7)
                .teacher(teacher)
                .build();

        repository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords=
            PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords=
                PageRequest.of(1,2);


        List<Course> courses =
                repository.findAll(secondPageWithTwoRecords).getContent();

        Long totalElements=
                repository.findAll(secondPageWithTwoRecords).getTotalElements();

        long totalPages=
                repository.findAll(secondPageWithTwoRecords).getTotalPages();

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher=Teacher.builder()
                .firstName("Jake")
                .lastName("Charles")
                .build();

        Student student=Student.builder()
                .firstName("Martin")
                .lastName("Mills")
                .emailId("martin@Mills.com")
                .build();

        Course course=Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        repository.save(course);
    }


}