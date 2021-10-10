package com.kp.jpa.Repository;

import com.kp.jpa.entity.Course;
import com.kp.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository repository;

    @Test
    public void saveTeacher(){
        Course courseDBA=Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseJava=Course.builder()
                .title("Java")
                .credit(2)
                .build();

        Teacher teacher=Teacher.builder()
                .firstName("Mary")
                .lastName("Ann")
                //.courses(List.of(courseDBA,courseJava))
                .build();
        repository.save(teacher);
    }
}