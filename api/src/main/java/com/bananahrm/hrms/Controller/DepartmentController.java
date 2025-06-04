package com.bananahrm.hrms.Controller;

import com.bananahrm.hrms.DTO.request.DepartmentRequest;
import com.bananahrm.hrms.DTO.response.DepartmentResponse;
import com.bananahrm.hrms.DTO.response.ResponseObject;
import com.bananahrm.hrms.Entity.Department;
import com.bananahrm.hrms.Service.department.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final IDepartmentService iDepartmentService;

    @PostMapping("/add")
    public ResponseObject<DepartmentResponse> handleAddDepartment(@RequestBody DepartmentRequest request) throws Exception {
        try{
            Department department = iDepartmentService.createDepartment(request.getName());
            DepartmentResponse departmentResponse = DepartmentResponse.builder().id(department.getId()).name(department.getName()).build();

            return ResponseObject.<DepartmentResponse>builder().status(200).message("Add new department successful.").data(departmentResponse).build();
        } catch (Exception e) {
            throw e;
        }
    }
}
