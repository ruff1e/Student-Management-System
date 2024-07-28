package com.student.studentDemo.controller;
import com.student.studentDemo.dto.GradesDTO;
import com.student.studentDemo.model.Grades;
import com.student.studentDemo.service.GradesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/grades")
public class GradesController {

    private final GradesService gradesService;


    @GetMapping("/student/{id}")
    public List<GradesDTO> getGradesByStudentId(@PathVariable int id) {
        return gradesService.getGradesByStudentId(id);
    }


    @PostMapping("/create-grade")
    public GradesDTO createGrade(@RequestBody GradesDTO gradesDTO) {
        return gradesService.createGrade(gradesDTO);
    }


}
