package com.flashj.user.convert;

import com.flashj.user.dto.tenant.BundleDTO;
import com.flashj.user.entity.Bundle;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BundleConvert {

    public static BundleDTO entity2dto(Bundle entity) {
        BundleDTO bundleDTO = new BundleDTO();
        BeanUtils.copyProperties(entity, bundleDTO);
        return bundleDTO;
    }

    public static Bundle dto2entity(BundleDTO dto) {
        Bundle bundle = new Bundle();
        BeanUtils.copyProperties(dto, bundle);
        return bundle;
    }

    public static List<BundleDTO> entitylist2dto(List<Bundle> bundles) {
        return bundles.stream().map(BundleConvert::entity2dto).collect(Collectors.toList());
    }
}
