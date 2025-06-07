package com.bananahrm.hrms.Service.leaveType;

import com.bananahrm.hrms.DTO.request.LeaveTypeRequest;
import com.bananahrm.hrms.Entity.LeaveType;
import com.bananahrm.hrms.Exception.AppException;
import com.bananahrm.hrms.Exception.ErrorCode;
import com.bananahrm.hrms.Rerpository.LeaveTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LeaveTypeService implements ILeaveTypeService {
    private final LeaveTypeRepository leaveTypeRepository;

    @Override
    public LeaveType addLeaveType(LeaveTypeRequest leaveType) throws Exception {
        if(leaveTypeRepository.existsLeaveTypesByName(leaveType.getName())){
            throw new AppException(ErrorCode.LEAVE_TYPE_EXIST);
        }

        LeaveType leaveTypeEntity = LeaveType.builder()
                .name(leaveType.getName())
                .build();

        return leaveTypeRepository.save(leaveTypeEntity);
    }

    @Override
    public LeaveType getLeaveType(Long id) throws Exception {
        Optional<LeaveType> leaveType = leaveTypeRepository.findById(id);
        if(leaveType.isEmpty()){
            throw new AppException(ErrorCode.LEAVE_TYPE_NOT_FOUND);
        }

        return leaveType.get();
    }

    @Override
    public List<LeaveType> getAllLeaveTypes() throws Exception {
        return leaveTypeRepository.findAll();
    }

    @Override
    public LeaveType updateLeaveType(Long id, LeaveTypeRequest leaveType) throws Exception {
        LeaveType oldLeaveType = this.getLeaveType(id);
        oldLeaveType.setName(leaveType.getName());

        return leaveTypeRepository.save(oldLeaveType);
    }

    @Override
    public void deleteLeaveType(Long id) throws Exception {
        LeaveType leaveType = this.getLeaveType(id);
        leaveTypeRepository.delete(leaveType);
    }
}
