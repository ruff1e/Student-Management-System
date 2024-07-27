package com.student.studentDemo.dto;

import com.student.studentDemo.model.Classes;
import jakarta.persistence.Column;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {

    private String name;
    private int age;
    private String email;
    private String address;

    private List<ClassDTO> classes;




}
