package com.student.studentDemo.controller;
import com.student.studentDemo.dto.StudentDTO;
import com.student.studentDemo.model.Student;
import com.student.studentDemo.repository.ClassesRepository;
import com.student.studentDemo.repository.StudentRepository;
import com.student.studentDemo.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final ClassesRepository classesRepository;


    @GetMapping("/find-all")
    public Set<StudentDTO> getAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.findStudentById(id);
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudentById(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    @PostMapping("/add-with-class")
    public Student saveStudentWithClass(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PostMapping("/{studentId}/add-class/{classId}")
    public Student addClassToStudent(@PathVariable int studentId, @PathVariable int classId) {
        return studentService.addClassToStudent(studentId, classId);
    }

    @PostMapping("/{studentId}/remove-class/{classId}")
    public Student removeClassFromStudent(@PathVariable int studentId, @PathVariable int classId) {
        return studentService.removeClassFromStudent(studentId, classId);
    }



}
