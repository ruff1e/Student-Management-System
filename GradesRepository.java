package com.student.studentDemo.repository;
import com.student.studentDemo.model.Grades;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GradesRepository extends JpaRepository<Grades, Integer> {
    List<Grades> findByStudentId(int studentId);

}
