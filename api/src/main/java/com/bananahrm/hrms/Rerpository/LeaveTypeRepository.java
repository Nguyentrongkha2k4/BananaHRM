package com.bananahrm.hrms.Rerpository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bananahrm.hrms.Entity.LeaveType;

public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long>{

    boolean existsLeaveTypesByName(String name);
}
