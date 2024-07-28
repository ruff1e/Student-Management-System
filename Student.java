package com.student.studentDemo.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;



@Entity
@Getter
@Setter
@Component
@NoArgsConstructor
@Table(name = "tbl_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;


    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "student_classes",
            joinColumns = {
                    @JoinColumn(name = "student_id", nullable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "class_id", nullable = false)
            }
    )

    private Set<Classes> classes;


    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Grades> grades;


    public Student(int id, String name, int age, String email, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
