package lk.ijse.aad.controller;

import lk.ijse.aad.constant.CommonResponse;
import lk.ijse.aad.dto.DepartmentDTO;
import lk.ijse.aad.service.DepartmentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lk.ijse.aad.constant.ResponseMessage.SUCCESS_MESSAGE;
import static lk.ijse.aad.constant.ResponseStatusCode.OPERATION_SUCCESS;

@RestController
@RequestMapping(value = "v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
//        return departmentService.saveDepartment(departmentDTO);
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MESSAGE);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DepartmentDTO> getAllDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DepartmentDTO getDepartmentById(@PathVariable("id") Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DepartmentDTO updateDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return departmentService.updateDepartment(departmentDTO);
    }

    @GetMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse filterDepartments
            (@RequestParam(value = "department_location", required = false) String departmentLocation,
             @RequestParam(value = "department_name", required = false) String departmentName) {

        List<DepartmentDTO> departmentDTOS = departmentService.filterDepartments(departmentLocation, departmentName);
        return new CommonResponse(OPERATION_SUCCESS, departmentDTOS,SUCCESS_MESSAGE);
    }
}
