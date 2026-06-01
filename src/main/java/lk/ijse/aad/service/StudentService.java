package lk.ijse.aad.service;

import lk.ijse.aad.dto.StudentDTO;
import lk.ijse.aad.dto.UserDTO;

import java.util.List;

public interface StudentService {
    StudentDTO saveStudent(StudentDTO studentDTO);
    List<StudentDTO> getStudents();
    StudentDTO getStudentById(Long id);
    StudentDTO updateStudent(StudentDTO studentDTO);

}
