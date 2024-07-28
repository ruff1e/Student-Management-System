package com.student.studentDemo.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Entity
@Component
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int numOfStudents;



    public Teacher(int id, String name, int numOfStudents) {
        this.id = id;
        this.name = name;
        this.numOfStudents = numOfStudents;
    }

    @JsonIgnore
    @OneToOne(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Classes aClass;


    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numOfStudents=" + numOfStudents +
                '}';
    }
}
