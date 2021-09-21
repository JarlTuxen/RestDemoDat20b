package dk.kea.restdemodat20b.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;
    LocalDate deadline;

    //@JsonBackReference
    //fuld stop for Jackson med JsonIgnore
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    public Assignment() {
    }

    public Assignment(String name, LocalDate deadline, Student student) {
        this.name = name;
        this.deadline = deadline;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
