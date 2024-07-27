package com.student.studentDemo.service;

import com.student.studentDemo.dto.ClassDTO;
import com.student.studentDemo.dto.StudentDTO;
import com.student.studentDemo.model.Classes;
import com.student.studentDemo.model.Student;
import com.student.studentDemo.repository.ClassesRepository;
import com.student.studentDemo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ClassesRepository classesRepository;

    public Set<StudentDTO> findAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> new StudentDTO(student.getName(),student.getAge(), student.getEmail(),student.getAddress(),
                        convertEntityToDto(student.getClasses())))
                .collect(Collectors.toSet());
    }

    private List<ClassDTO> convertEntityToDto(Set<Classes> classes) {
        return classes.stream()
                .map(classObject -> ClassDTO.builder().name(classObject.getName()).build())
                .collect(Collectors.toList());
    }

    public Student findStudentById(int studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(int studentId) {
        studentRepository.deleteById(studentId);
    }

    public List<Classes> findClasses(int studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);

        if (student != null) {
            return new ArrayList<>(student.getClasses());
        }
        return new ArrayList<>();
    }



    public Student addClassToStudent(int studentId, int classId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Classes classes = classesRepository.findById(classId).orElse(null);

        if (student != null && classes != null) {
            student.getClasses().add(classes);
            return studentRepository.save(student);
        }
        return null;
    }


    public Student removeClassFromStudent(int studentId, int classId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Classes classes = classesRepository.findById(classId).orElse(null);

        if (student != null && classes != null) {
            student.getClasses().remove(classes);
            return studentRepository.save(student);
        }
        return null;
    }

}
