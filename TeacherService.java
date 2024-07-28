package com.student.studentDemo.service;
import com.student.studentDemo.model.Teacher;
import com.student.studentDemo.repository.StudentRepository;
import com.student.studentDemo.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;


    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher findById(int id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public long numOfStudents(){
        return studentRepository.count();
    }


}
