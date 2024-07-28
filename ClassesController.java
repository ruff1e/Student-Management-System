package com.student.studentDemo.controller;
import com.student.studentDemo.dto.ClassDTO;
import com.student.studentDemo.model.Classes;
import com.student.studentDemo.service.ClassesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/classes")
public class ClassesController {

    private final ClassesService classesService;

    @GetMapping("/find-all")
    public List<ClassDTO> getAllClasses() {
        return classesService.findAllClasses();
    }

    @GetMapping("/{id}")
    public Classes findClassById(@PathVariable int id) {
        return classesService.findClassById(id);
    }

    @PostMapping("/add")
    public Classes saveClass(@RequestBody Classes classes) {
        return classesService.saveClass(classes);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClassById(@PathVariable int id) {
        classesService.deleteClassById(id);
    }

    @PostMapping("/{classId}/add-student-to-class/{studentId}")
    public Classes addStudentToClass(@PathVariable int classId, @PathVariable int studentId) {
        return classesService.addStudentToClass(classId, studentId);
    }

    @PostMapping("/{classId}/remove-student-from-class/{studentId}")
    public Classes removeStudentFromClass(@PathVariable int classId, @PathVariable int studentId) {
        return classesService.removeStudentFromClass(classId, studentId);
    }

    @GetMapping("/student/{id}")
    public List<Classes> findClassesStudentEnrolled(@PathVariable int id) {
        return classesService.findClassesStudentEnrolled(id);
    }



}
