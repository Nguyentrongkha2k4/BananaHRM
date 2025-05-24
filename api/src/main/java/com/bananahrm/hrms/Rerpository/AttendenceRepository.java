package com.bananahrm.hrms.Rerpository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bananahrm.hrms.Entity.Attendance;

public interface AttendenceRepository extends JpaRepository<Attendance, Long>{

}
