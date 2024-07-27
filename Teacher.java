package com.student.studentDemo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private int id;
    private String name;
    private int numOfStudents;



    public Teacher(int id, String name, int numOfStudents) {
        this.id = id;
        this.name = name;
        this.numOfStudents = numOfStudents;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numOfStudents=" + numOfStudents +
                '}';
    }
}
