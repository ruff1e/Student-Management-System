package com.student.studentDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GradesDTO {

    private int id;
    private int value;
    private int studentId;
    private int classId;


}
