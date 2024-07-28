package com.student.studentDemo.controller;
import com.student.studentDemo.model.Teacher;
import com.student.studentDemo.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;


    @GetMapping("/find-all")
    public List<Teacher> getAllTeachers() {
        return teacherService.findAllTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable int id) {
        return teacherService.findById(id);
    }

    @GetMapping("/numStudents")
    public long getNumOfStudents(int id) {
        return teacherService.numOfStudents();
    }

}
