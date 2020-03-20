package com.flashj.user.convert;


import com.flashj.user.dto.resource.ApplicationDTO;
import com.flashj.user.entity.ResourceApplication;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ResourceApplicationConvert {

    public static ApplicationDTO entity2dto(ResourceApplication entity) {
        ApplicationDTO applicationDTO = new ApplicationDTO();
        BeanUtils.copyProperties(entity, applicationDTO);
        return applicationDTO;
    }

    public static ResourceApplication dto2entity(ApplicationDTO dto) {
        ResourceApplication resourceApplication = new ResourceApplication();
        BeanUtils.copyProperties(dto, resourceApplication);
        return resourceApplication;
    }

    public static List<ApplicationDTO> entitylist2dto(List<ResourceApplication> resourceApplications) {
        return resourceApplications.stream().map(ResourceApplicationConvert::entity2dto).collect(Collectors.toList());
    }
}
