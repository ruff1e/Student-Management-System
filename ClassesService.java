package com.student.studentDemo.service;
import com.student.studentDemo.dto.ClassDTO;
import com.student.studentDemo.model.Classes;
import com.student.studentDemo.model.Student;
import com.student.studentDemo.repository.ClassesRepository;
import com.student.studentDemo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
public class ClassesService {

    private final ClassesRepository classesRepository;
    private final StudentRepository studentRepository;

    public List<ClassDTO> findAllClasses() {
        List<Classes> classes = classesRepository.findAll();
        return classes.stream()
                .map(c -> new ClassDTO(
                        c.getName(),
                        Math.toIntExact(c.getId())))
                .collect(Collectors.toList());
    }

    public Classes findClassById(int id) {
        return classesRepository.findById(id).orElse(null);
    }

    public Classes saveClass(Classes classes) {
        return classesRepository.save(classes);
    }

    public void deleteClassById(int id) {
        classesRepository.deleteById(id);
    }

    public Classes addStudentToClass(int classId, int studentId) {
        Classes classes = classesRepository.findById(classId).orElse(null);
        Student student = studentRepository.findById(studentId).orElse(null);

        if (classes != null && student != null) {
            classes.getStudents().add(student);
            return classesRepository.save(classes);
        }
        return null;
    }


    public Classes removeStudentFromClass(int classId, int studentId) {
        Classes classes = classesRepository.findById(classId).orElse(null);
        Student student = studentRepository.findById(studentId).orElse(null);

        if (classes != null && student != null) {
            classes.getStudents().remove(student);
            return classesRepository.save(classes);
        }
        return null;
    }

    public List<Classes> findClassesStudentEnrolled(int studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);

        if (student != null) {
            return new ArrayList<>(student.getClasses());
        }
        return new ArrayList<>();
    }


}
