package lk.ijse.aad.service;

import lk.ijse.aad.dto.DepartmentDTO;


import java.util.List;

public interface DepartmentService {
    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);
    List<DepartmentDTO> getDepartments();
    DepartmentDTO getDepartmentById(Long id);
}
