package com.student.studentDemo.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Component
public class Grades {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int value;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Classes classes;

    @Override
    public String toString() {
        return "Grades{" +
                "id=" + id +
                ", value=" + value +
                ", student=" + student +
                ", classes=" + classes +
                '}';
    }

}
