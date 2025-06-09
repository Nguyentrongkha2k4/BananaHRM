package com.bananahrm.hrms.Controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bananahrm.hrms.DTO.request.LeaveRequestRequest;
import com.bananahrm.hrms.DTO.response.LeaveRequestResponse;
import com.bananahrm.hrms.DTO.response.ResponseObject;
import com.bananahrm.hrms.Entity.LeaveRequest;
import com.bananahrm.hrms.Entity.User;
import com.bananahrm.hrms.Service.leaveRequestService.ILeaveRequestService;
import com.bananahrm.hrms.Service.user.IUserService;
import com.bananahrm.hrms.mapper.LeaveRequestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("leaves")
@RequiredArgsConstructor
public class LeaveRequestController {
    public final ILeaveRequestService iLeaveRequestService;
    public final LeaveRequestMapper leaveRequestMapper;
    private final IUserService iUserService;

    @PostMapping("")
    public ResponseObject<LeaveRequestResponse> handleAddLeaveRequest(@RequestBody LeaveRequestRequest request) throws Exception {
        try {
            LeaveRequest leaveRequest = iLeaveRequestService.createLeaveRequest(request);

            return ResponseObject.<LeaveRequestResponse>builder()
                    .status(200)
                    .message("LeaveRequest Created")
                    .data(leaveRequestMapper.toDTO(leaveRequest))
                    .build();
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("")
    public ResponseObject<List<LeaveRequestResponse>> handleGetAllLeaveRequest() throws Exception {
        try {
            List<LeaveRequest> leaveRequests = iLeaveRequestService.getAllLeaveRequest();
            List<LeaveRequestResponse> leaveRequestResponses = leaveRequests.stream()
                    .map(leaveRequestMapper::toDTO).toList();

            return ResponseObject.<List<LeaveRequestResponse>>builder()
                    .status(200)
                    .message("Get all LeaveRequest successfully")
                    .data(leaveRequestResponses)
                    .build();
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/{id}")
    public ResponseObject<LeaveRequestResponse> handleGetLeaveRequestById(@PathVariable Long id) throws Exception {
        try {
            LeaveRequest leaveRequest = iLeaveRequestService.getLeaveRequestById(id);

            return ResponseObject.<LeaveRequestResponse>builder()
                    .status(200)
                    .message("Get LeaveRequest Successfully")
                    .data(leaveRequestMapper.toDTO(leaveRequest))
                    .build();
        } catch (Exception e){
            throw e;
        }
    }

    @PutMapping("/{id}")
    public ResponseObject<LeaveRequestResponse> handleUpdateLeaveRequest(@PathVariable Long id, @RequestBody LeaveRequestRequest request) throws Exception {
        try{
            LeaveRequest leaveRequest = iLeaveRequestService.updateLeaveRequest(id, request);

            return ResponseObject.<LeaveRequestResponse>builder()
                    .status(200)
                    .message("Update LeaveRequest Successfully")
                    .data(leaveRequestMapper.toDTO(leaveRequest))
                    .build();
        } catch (Exception e){
            throw e;
        }
    }

//    @PreAuthorize("hasRole('ADMIN') or hasRole('HR')")
    @PutMapping("/approve/{id}")
    public ResponseObject<LeaveRequestResponse> handleApproveLeaveRequest(@PathVariable Long id) throws Exception {
        try{
            String userId = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = iUserService.getUser(Long.parseLong(userId));

            LeaveRequest leaveRequest = iLeaveRequestService.approveLeaveRequest(id, user.getEmployeeId());

            return ResponseObject.<LeaveRequestResponse>builder()
                    .status(200)
                    .message("Approve LeaveRequest Successfully")
                    .data(leaveRequestMapper.toDTO(leaveRequest))
                    .build();
        } catch (Exception e){
            throw e;
        }
    }

//    @PreAuthorize("hasRole('ADMIN') or hasRole('HR')")
    @PutMapping("/reject/{id}")
    public ResponseObject<LeaveRequestResponse> handleRejectLeaveRequest(@PathVariable Long id) throws Exception {
        try{
            String userId = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = iUserService.getUser(Long.parseLong(userId));

            LeaveRequest leaveRequest = iLeaveRequestService.rejectLeaveRequest(id, user.getEmployeeId());

            return ResponseObject.<LeaveRequestResponse>builder()
                    .status(200)
                    .message("Reject LeaveRequest Successfully")
                    .data(leaveRequestMapper.toDTO(leaveRequest))
                    .build();
        } catch (Exception e){
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseObject<Void> handleDeleteLeaveRequest(@PathVariable Long id) throws Exception {
        try {
            iLeaveRequestService.deleteLeaveRequest(id);

            return ResponseObject.<Void>builder()
                    .status(200)
                    .message("Delete LeaveRequest Successfully")
                    .build();
        } catch (Exception e) {
            throw e;
        }
    }

}
