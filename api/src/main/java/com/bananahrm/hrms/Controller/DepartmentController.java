package com.bananahrm.hrms.Controller;

import com.bananahrm.hrms.DTO.request.DepartmentRequest;
import com.bananahrm.hrms.DTO.request.DepartmentRequest;
import com.bananahrm.hrms.DTO.response.DepartmentResponse;
import com.bananahrm.hrms.DTO.response.DepartmentResponse;
import com.bananahrm.hrms.DTO.response.ResponseObject;
import com.bananahrm.hrms.Entity.Department;
import com.bananahrm.hrms.Entity.Department;
import com.bananahrm.hrms.Service.department.IDepartmentService;
import com.bananahrm.hrms.mapper.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final IDepartmentService iDepartmentService;
    private final DepartmentMapper departmentMapper;
    
    @PostMapping("")
    public ResponseObject<DepartmentResponse> handleAddDepartment(@RequestBody DepartmentRequest request) throws Exception {
        try{
            Department department = iDepartmentService.createDepartment(request.getName());
            DepartmentResponse departmentResponse = DepartmentResponse.builder().id(department.getId()).name(department.getName()).build();

            return ResponseObject.<DepartmentResponse>builder().status(200).message("Add new department successful.").data(departmentResponse).build();
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("")
    public ResponseObject<List<DepartmentResponse>> handleGetAllDepartment() throws Exception {
        try{
            List<Department> lDepartments = iDepartmentService.getAllDepartment();
            List<DepartmentResponse> lDepartmentResponse = lDepartments.stream()
                    .map(departmentMapper::toDTO)
                    .toList();
            return ResponseObject.<List<DepartmentResponse>>builder()
                    .status(200).message("Get all job title successfully.").data(lDepartmentResponse).build();
        } catch(Exception e){
            throw e;
        }
    }

    @GetMapping("/{id}")
    public ResponseObject<DepartmentResponse> handleGetDepartmentById(@PathVariable String id) throws Exception{
        try{
            Department Department = iDepartmentService.getDepartmentById(Long.parseLong(id));

            return ResponseObject.<DepartmentResponse>builder()
                    .status(200)
                    .message("Get Job Title Successfully.")
                    .data(departmentMapper.toDTO(Department))
                    .build();
        } catch (Exception e) {
            throw e;
        }
    }

    @PutMapping("/{id}")
    public ResponseObject<DepartmentResponse> handleUpdateDepartment(@PathVariable String id, @RequestBody DepartmentRequest request) throws Exception{
        try{
            Department Department = iDepartmentService.updateDepartment(Long.parseLong(id), request.getName());

            return ResponseObject.<DepartmentResponse>builder()
                    .status(200)
                    .message("Update job title successfully.")
                    .data(departmentMapper.toDTO(Department))
                    .build();
        } catch (Exception e){
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseObject<DepartmentResponse> handleDeleteDepartment(@PathVariable String id) throws Exception{
        try{
            Department Department = iDepartmentService.deleteDepartment(Long.parseLong(id));

            return ResponseObject.<DepartmentResponse>builder()
                    .status(200)
                    .message("Delete job title successfully.")
                    .data(departmentMapper.toDTO(Department))
                    .build();
        } catch (Exception e){
            throw e;
        }
    }
}
