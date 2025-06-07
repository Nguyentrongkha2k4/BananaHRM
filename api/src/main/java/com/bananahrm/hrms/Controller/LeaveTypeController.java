package com.bananahrm.hrms.Controller;

import com.bananahrm.hrms.DTO.request.LeaveTypeRequest;
import com.bananahrm.hrms.DTO.response.LeaveTypeResponse;
import com.bananahrm.hrms.DTO.response.ResponseObject;
import com.bananahrm.hrms.Entity.LeaveType;
import com.bananahrm.hrms.Service.leaveType.ILeaveTypeService;
import com.bananahrm.hrms.mapper.LeaveTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaveTypes")
@RequiredArgsConstructor
public class LeaveTypeController {
    public final ILeaveTypeService iLeaveTypeService;
    public final LeaveTypeMapper leaveTypeMapper;

    @PostMapping("")
    public ResponseObject<LeaveTypeResponse> addLeaveType(@RequestBody LeaveTypeRequest request) throws Exception{
        try{
            LeaveType leaveType = iLeaveTypeService.addLeaveType(request);

            return ResponseObject.<LeaveTypeResponse>builder()
                    .status(200)
                    .message("Success")
                    .data(leaveTypeMapper.toDTO(leaveType))
                    .build();
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("")
    public ResponseObject<List<LeaveTypeResponse>> getAllLeaveTypes() throws Exception{
        try{
            List<LeaveType> leaveTypes = iLeaveTypeService.getAllLeaveTypes();

            List<LeaveTypeResponse> leaveTypeResponses = leaveTypes.stream().map(
                    leaveTypeMapper::toDTO
            ).toList();

            return ResponseObject.<List<LeaveTypeResponse>>builder()
                    .status(200)
                    .message("Get all leave type successfully")
                    .data(leaveTypeResponses)
                    .build();
        }catch (Exception e){
            throw e;
        }
    }

    @GetMapping("/{id}")
    public ResponseObject<LeaveTypeResponse> getLeaveTypeById(@PathVariable("id") Long id) throws Exception{
        try{
            LeaveType leaveType = iLeaveTypeService.getLeaveType(id);

            return ResponseObject.<LeaveTypeResponse>builder()
                    .status(200)
                    .message("Get leave type successfully")
                    .data(leaveTypeMapper.toDTO(leaveType))
                    .build();
        }catch (Exception e){
            throw e;
        }
    }

    @PutMapping("/{id}")
    public ResponseObject<LeaveTypeResponse> updateLeaveType(@PathVariable("id") Long id, @RequestBody LeaveTypeRequest request) throws Exception{
        try {
            LeaveType leaveType = iLeaveTypeService.updateLeaveType(id, request);

            return ResponseObject.<LeaveTypeResponse>builder()
                    .status(200)
                    .message("Update leave type successfully")
                    .data(leaveTypeMapper.toDTO(leaveType))
                    .build();
        } catch (Exception e) {
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseObject<Void> deleteLeaveType(@PathVariable("id") Long id) throws Exception{
        try {
            iLeaveTypeService.deleteLeaveType(id);

            return ResponseObject.<Void>builder()
                    .status(200)
                    .message("Delete leave type successfully")
                    .build();
        } catch (Exception e) {
            throw e;
        }
    }

}
