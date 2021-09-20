package dk.kea.restdemodat20b.controller;

import dk.kea.restdemodat20b.model.Student;
import dk.kea.restdemodat20b.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/students")
@RestController
public class StudentController {

    private StudentRepository studentRepository;

    //constructor injection i stedet for field injection (autowired)
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //HTTP GET (/students)
    @GetMapping
    public ResponseEntity<List<Student>> findAll(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        //ResponseEntity builder - først status OK/200 - så til sidst body
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    //HTTP GET (/students/{id}) - findById
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> findById(@PathVariable Long id){
        //hent student fra repository
        Optional<Student> optionalStudent = studentRepository.findById(id);
        //er student fundet?
        if (optionalStudent.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalStudent);
        }
        else{
            //not found 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optionalStudent);
        }
    }

    //HTTP Post (/students)) - create

    //HTTP Put (/students/{id}) - update

    //HTTP Delete (/students/{id}) - delete

}
