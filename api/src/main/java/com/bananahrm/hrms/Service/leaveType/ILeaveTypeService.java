package com.bananahrm.hrms.Service.leaveType;

import com.bananahrm.hrms.DTO.request.LeaveTypeRequest;
import com.bananahrm.hrms.Entity.LeaveType;

import java.util.List;

public interface ILeaveTypeService {
    public LeaveType addLeaveType(LeaveTypeRequest leaveType) throws Exception;
    public LeaveType getLeaveType(Long id) throws Exception;
    public List<LeaveType> getAllLeaveTypes() throws Exception;
    public LeaveType updateLeaveType(Long id, LeaveTypeRequest leaveType) throws Exception;
    public void deleteLeaveType(Long id) throws Exception;

}
