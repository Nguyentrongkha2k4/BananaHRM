package com.bananahrm.hrms.Service.leaveRequestService;

import com.bananahrm.hrms.DTO.request.LeaveRequestRequest;
import com.bananahrm.hrms.Entity.LeaveRequest;
import com.bananahrm.hrms.Exception.AppException;
import com.bananahrm.hrms.Exception.ErrorCode;
import com.bananahrm.hrms.Rerpository.LeaveRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LeaveRequestService implements ILeaveRequestService{
    private final LeaveRequestRepository leaveRequestRepository;


    @Override
    public LeaveRequest createLeaveRequest(LeaveRequestRequest request) throws Exception {
        LeaveRequest leaveRequest = LeaveRequest.builder()
                .leaveTypeId(request.getLeaveTypeId())
                .fromDate(request.getFromDate())
                .toDate(request.getToDate())
                .reason(request.getReason())
                .build();

        return leaveRequestRepository.save(leaveRequest);
    }

    @Override
    public LeaveRequest getLeaveRequestById(Long leaveRequestId) throws Exception {
        Optional<LeaveRequest> leaveRequest = leaveRequestRepository.findById(leaveRequestId);
        if(leaveRequest.isEmpty()) {
            throw new AppException((ErrorCode.LEAVE_REQUEST_NOT_FOUND));
        }

        return leaveRequest.get();
    }

    @Override
    public List<LeaveRequest> getAllLeaveRequest() throws Exception {
        return leaveRequestRepository.findAll();
    }

    @Override
    public LeaveRequest updateLeaveRequest(Long id, LeaveRequestRequest request) throws Exception {
        LeaveRequest leaveRequest = this.getLeaveRequestById(id);

        leaveRequest.setLeaveTypeId(request.getLeaveTypeId());
        leaveRequest.setFromDate(request.getFromDate());
        leaveRequest.setToDate(request.getToDate());
        leaveRequest.setReason(request.getReason());

        return leaveRequestRepository.save(leaveRequest);
    }

    @Override
    public void deleteLeaveRequest(Long id) throws Exception {
        LeaveRequest leaveRequest = this.getLeaveRequestById(id);
        leaveRequestRepository.delete(leaveRequest);
    }

    @Override
    public LeaveRequest approveLeaveRequest(Long id, Long approveBy) throws Exception {
        LeaveRequest leaveRequest = this.getLeaveRequestById(id);
        leaveRequest.setLeaveTypeId(approveBy);

        return leaveRequestRepository.save(leaveRequest);
    }

    @Override
    public LeaveRequest rejectLeaveRequest(Long id, Long rejectBy) throws Exception {
        LeaveRequest leaveRequest = this.getLeaveRequestById(id);
        leaveRequest.setLeaveTypeId(rejectBy);

        return leaveRequestRepository.save(leaveRequest);
    }
}
