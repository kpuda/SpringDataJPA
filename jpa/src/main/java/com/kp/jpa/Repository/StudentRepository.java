package com.kp.jpa.Repository;

import com.kp.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName,
                                       String lastName);

    //JPQL query
    /*@Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String email);

    //Native queries
    @Query(
            value = "SELECT * FROM tbl_students s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    Student getStudentByEmailAddressNativeNamedParam(
            @Param("emailId") String emailId
    );


    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);*/
}
