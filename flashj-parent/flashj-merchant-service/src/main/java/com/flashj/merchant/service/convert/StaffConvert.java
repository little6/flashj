package com.flashj.merchant.service.convert;

import com.flashj.merchant.service.dto.StaffDTO;
import com.flashj.merchant.service.entity.Staff;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class StaffConvert {

    public static StaffDTO entity2dto(Staff entity){
        StaffDTO staffDTO=new StaffDTO();
        BeanUtils.copyProperties(entity,staffDTO);
        return staffDTO;
    }

    public static Staff dto2entity(StaffDTO dto){
        Staff staff=new Staff();
        BeanUtils.copyProperties(dto,staff);
        return staff;
    }

    public static List<StaffDTO> listentity2dto(List<Staff> staffs){
        return staffs.parallelStream().map(StaffConvert::entity2dto).collect(Collectors.toList());
    }

}
