package com.ibik.academicservices.academicservices.student;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudentRepo extends CrudRepository<Student, Integer>{

    @Query("SELECT a FROM Student a WHERE a.firstname LIKE :name OR a.middlename LIKE :name OR a.lastname LIKE :name OR a.npm LIKE :name")
    public Iterable<Student> findStudentByName(@PathParam("name") String name);

    @Query(value = "SELECT a.* FROM student a WHERE a.email = :email AND concat(DATE_FORMAT(a.birthdate, '%d%m%Y'), '@', a.npm) = :password", nativeQuery = true)
    public Iterable<Student> findStudentAuth(@Param("email") String email, @Param("password") String password);
}
