package lk.ijse.aad.service.impl;

import lk.ijse.aad.dto.StudentDTO;
import lk.ijse.aad.entity.School;
import lk.ijse.aad.entity.Student;
import lk.ijse.aad.repository.SchoolRepository;
import lk.ijse.aad.repository.StudentRepository;
import lk.ijse.aad.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;

    public StudentServiceImpl(StudentRepository studentRepository, SchoolRepository schoolRepository) {
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        log.info("StudentServiceImpl saveStudent");

        try{
            if(studentDTO.getFirstName() == null){
                throw new RuntimeException("first name is null");
            }
            if(studentDTO.getLastName() == null){
                throw new RuntimeException("last name is null");
            }
            if (studentDTO.getAddress() == null){
                throw new RuntimeException("address is null");
            }
            if(studentDTO.getDob() == null){
                throw new RuntimeException("dob is null");
            }

            Student student = new Student();
            student.setFirstName(studentDTO.getFirstName());
            student.setLastName(studentDTO.getLastName());
            student.setAddress(studentDTO.getAddress());
            student.setDob(studentDTO.getDob());

            Optional<School> optionalSchool = schoolRepository.findById(studentDTO.getSchoolId());
            if(!optionalSchool.isPresent()){
                throw new RuntimeException("school not found");
            }

            School school = optionalSchool.get();
            student.setSchool(school);

            Student savedStudent = studentRepository.save(student);

            StudentDTO savedStudentDTO = new StudentDTO();
            savedStudentDTO.setId(savedStudent.getId());
            savedStudentDTO.setFirstName(savedStudent.getFirstName());
            savedStudentDTO.setLastName(savedStudent.getLastName());
            savedStudentDTO.setAddress(savedStudent.getAddress());
            savedStudentDTO.setDob(savedStudent.getDob());
            savedStudentDTO.setSchoolId(savedStudent.getSchool().getId());

            return savedStudentDTO;
        } catch (Exception e) {
            log.error("error occurred in save student" +e.getMessage());
            throw e;
        }
    }

    @Override
    public List<StudentDTO> getStudents() {
        log.info("StudentServiceImpl getStudents");
        try{
            List<Student> students = studentRepository.findAll();
            List<StudentDTO> studentDTOS = new ArrayList<>();
            for (Student student : students) {
                StudentDTO studentDTO = new StudentDTO();
                studentDTO.setId(student.getId());
                studentDTO.setFirstName(student.getFirstName());
                studentDTO.setLastName(student.getLastName());
                studentDTO.setAddress(student.getAddress());
                studentDTO.setDob(student.getDob());
                studentDTO.setSchoolId(student.getSchool().getId());
                studentDTOS.add(studentDTO);
            }
            return studentDTOS;
        } catch (Exception e) {
            log.error("error occurred in getStudents");
            throw e;
        }
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        log.info("StudentServiceImpl getStudentById");
        try{
            Optional<Student> studentOptional = studentRepository.findById(id);
            if(!studentOptional.isPresent()){
                throw new RuntimeException("student not found");
            }
            Student student = studentOptional.get();
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(student.getId());
            studentDTO.setFirstName(student.getFirstName());
            studentDTO.setLastName(student.getLastName());
            studentDTO.setAddress(student.getAddress());
            studentDTO.setDob(student.getDob());
            studentDTO.setSchoolId(student.getSchool().getId());
            return studentDTO;
        } catch (Exception e) {
            log.error("error occurred in getStudentById");
            throw e;
        }
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        log.info("StudentServiceImpl updateStudent");

        try{
            Optional<Student> studentOptional = studentRepository.findById(studentDTO.getId());
            if(!studentOptional.isPresent()){
                throw new RuntimeException("student not found");
            }

            if(studentDTO.getFirstName() == null){
                throw new RuntimeException("first name is null");
            }
            if(studentDTO.getLastName() == null){
                throw new RuntimeException("last name is null");
            }
            if (studentDTO.getAddress() == null){
                throw new RuntimeException("address is null");
            }
            if (studentDTO.getDob() == null){
                throw new RuntimeException("dob is null");
            }

            Student student = studentOptional.get();
            student.setFirstName(studentDTO.getFirstName());
            student.setLastName(studentDTO.getLastName());
            student.setAddress(studentDTO.getAddress());
            student.setDob(studentDTO.getDob());
            Student savedStudent = studentRepository.save(student);

            StudentDTO savedStudentDTO = new StudentDTO();
            savedStudentDTO.setId(savedStudent.getId());
            savedStudentDTO.setFirstName(savedStudent.getFirstName());
            savedStudentDTO.setLastName(savedStudent.getLastName());
            savedStudentDTO.setAddress(savedStudent.getAddress());
            savedStudentDTO.setDob(savedStudent.getDob());
            return savedStudentDTO;

        }catch (Exception e){
            log.error("error occurred in getStudentById");
            throw e;
        }
    }
}
