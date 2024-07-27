package com.student.studentDemo.repository;

import com.student.studentDemo.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassesRepository extends JpaRepository<Classes, Integer> {
}
