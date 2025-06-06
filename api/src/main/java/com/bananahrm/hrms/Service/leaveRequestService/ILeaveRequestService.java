package com.bananahrm.hrms.Service.leaveRequestService;

import com.bananahrm.hrms.DTO.request.LeaveRequestRequest;
import com.bananahrm.hrms.Entity.LeaveRequest;

import java.util.List;

public interface ILeaveRequestService {
    LeaveRequest createLeaveRequest(LeaveRequestRequest request) throws Exception;
    LeaveRequest getLeaveRequestById(Long leaveRequestId) throws Exception;
    List<LeaveRequest> getAllLeaveRequest() throws Exception;
    LeaveRequest updateLeaveRequest(Long id, LeaveRequestRequest request) throws Exception;
    void deleteLeaveRequest(Long id) throws Exception;
    LeaveRequest approveLeaveRequest(Long id, Long approveBy) throws Exception;
    LeaveRequest rejectLeaveRequest(Long id, Long rejectBy) throws Exception;
}
