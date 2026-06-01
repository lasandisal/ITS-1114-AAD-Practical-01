package lk.ijse.aad.controller;

import lk.ijse.aad.dto.StudentDTO;
import lk.ijse.aad.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO){
        return studentService.saveStudent(studentDTO);
    }

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentDTO> getAllStudents(){
        return studentService.getStudents();
    }

    @GetMapping(value = "/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentDTO getStudent(@PathVariable("studentId") Long studentId){
        return studentService.getStudentById(studentId);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO){
        return studentService.updateStudent(studentDTO);
    }
}
