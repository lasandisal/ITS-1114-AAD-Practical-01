package lk.ijse.aad.service.impl;

import lk.ijse.aad.dto.DepartmentDTO;
import lk.ijse.aad.entity.Department;
import lk.ijse.aad.repository.DepartmentRepository;
import lk.ijse.aad.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        log.info("saveDepartment loaded");

        try {
//            Department department = new Department();
//            department.setDepartment_name("Human Resources");
//            department.setDepartment_location("Galle");
//
//            Department saveDepartment = departmentRepository.save(department);
//
//            DepartmentDTO departmentDTO = new DepartmentDTO();
//            departmentDTO.setDepartment_name(saveDepartment.getDepartment_name());
//            departmentDTO.setDepartment_location(saveDepartment.getDepartment_location());
//
//            log.info("Department saved");
//            return departmentDTO;

            Department department = new Department();
            department.setDepartment_name(departmentDTO.getDepartment_name());
            department.setDepartment_location(departmentDTO.getDepartment_location());

            Department savedDepartment = departmentRepository.save(department);


            DepartmentDTO saveDepartmentDTO = new DepartmentDTO();
            saveDepartmentDTO.setDepartment_name(savedDepartment.getDepartment_name());
            saveDepartmentDTO.setDepartment_location(savedDepartment.getDepartment_location());
            log.info("Department saved successfully");
            return saveDepartmentDTO;

        } catch (Exception e) {
            log.error("Error occurred." + e.getMessage());
            throw e;
        }

    }

    @Override
    public List<DepartmentDTO> getDepartments() {
        log.info("getDepartments loaded");

        try{
            List<Department> departments = departmentRepository.findAll();
            List<DepartmentDTO> departmentDTOS = new ArrayList<>();

            for (Department department : departments) {
                DepartmentDTO departmentDTO = new DepartmentDTO();
                departmentDTO.setDepartment_name(department.getDepartment_name());
                departmentDTO.setDepartment_location(department.getDepartment_location());
                departmentDTOS.add(departmentDTO);
            }
            return departmentDTOS;

        } catch (Exception e) {
            log.error("getDepartments failed" + e.getMessage());
            throw e;
        }
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        log.info("getDepartmentById loaded for ID {}", id);

        try{
            Department department = departmentRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Department with ID " + id + " not found"));

            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setDepartment_id(department.getDepartment_id());
            departmentDTO.setDepartment_name(department.getDepartment_name());
            departmentDTO.setDepartment_location(department.getDepartment_location());
            return departmentDTO;

        } catch (Exception e) {
            log.error("Error in getDepartmentById!!!" + e.getMessage());
            throw e;
        }
    }
}
