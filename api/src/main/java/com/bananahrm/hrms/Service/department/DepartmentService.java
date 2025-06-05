package com.bananahrm.hrms.Service.department;

import com.bananahrm.hrms.Exception.AppException;
import com.bananahrm.hrms.Exception.ErrorCode;
import com.bananahrm.hrms.Rerpository.DepartmentRepository;
import org.springframework.stereotype.Service;

import com.bananahrm.hrms.Entity.Department;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService{
    private final DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(String name) throws Exception {
        if (name == null || name.trim().isEmpty()){
            throw new AppException(ErrorCode.DEPARTMENT_EMPTY);
        }

        if(departmentRepository.existsDepartmentByName(name)){
            throw new AppException(ErrorCode.DEPARTMENT_EXIST);
        }

        Department department = Department.builder().name(name).build();

        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) throws Exception {
        Optional<Department> departmentOptional = departmentRepository.findById(id);

        if(departmentOptional.isEmpty()) {
            throw new AppException(ErrorCode.DEPARTMENT_NOT_FOUND);
        }

        return departmentOptional.get();
    }

    @Override
    public List<Department> getAllDepartment() throws Exception {
        return departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Long id, String name) throws Exception {
        Department department = this.getDepartmentById(id);
        department.setName(name);

        return departmentRepository.save(department);
    }

    @Override
    public Department deleteDepartment(Long id) throws Exception {
        Department department = this.getDepartmentById(id);
        departmentRepository.delete(department);

        return department;
    }

}
