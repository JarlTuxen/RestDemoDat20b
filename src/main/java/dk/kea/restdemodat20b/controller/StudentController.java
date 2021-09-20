package dk.kea.restdemodat20b.controller;

import dk.kea.restdemodat20b.model.Student;
import dk.kea.restdemodat20b.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private StudentRepository studentRepository;

    //constructor injection i stedet for field injection (autowired)
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //HTTP GET (/students)
    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    //HTTP GET (/students/{id}) - findById

    //HTTP Post (/students)) - create

    //HTTP Put (/students/{id}) - update

    //HTTP Delete (/students/{id}) - delete

}
