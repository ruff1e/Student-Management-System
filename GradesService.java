package com.student.studentDemo.service;
import com.student.studentDemo.dto.GradesDTO;
import com.student.studentDemo.model.Classes;
import com.student.studentDemo.model.Grades;
import com.student.studentDemo.model.Student;
import com.student.studentDemo.repository.ClassesRepository;
import com.student.studentDemo.repository.GradesRepository;
import com.student.studentDemo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
public class GradesService {

    private final StudentRepository studentRepository;
    private final ClassesRepository classesRepository;
    private final GradesRepository gradesRepository;


    public GradesDTO createGrade(GradesDTO gradeDTO) {
        return studentRepository.findById(gradeDTO.getStudentId())
                .flatMap(student -> classesRepository.findById(gradeDTO.getClassId())
                        .map(classes -> {
                            Grades grade = new Grades();
                            grade.setValue(gradeDTO.getValue());
                            grade.setStudent(student);
                            grade.setClasses(classes);
                            grade = gradesRepository.save(grade);
                            return new GradesDTO(grade.getId(), grade.getValue(), grade.getStudent().getId(), grade.getClasses().getId());
                        }))
                .orElse(null);
    }


    public List<GradesDTO> getGradesByStudentId(int studentId) {
        List<Grades> grades = gradesRepository.findByStudentId(studentId);
        return grades.stream()
                .map(grade -> new GradesDTO(grade.getId(), grade.getValue(), grade.getStudent().getId(), grade.getClasses().getId()))
                .collect(Collectors.toList());
    }


}
