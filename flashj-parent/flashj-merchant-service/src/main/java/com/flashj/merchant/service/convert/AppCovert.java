package com.flashj.merchant.service.convert;

import com.flashj.merchant.service.dto.AppDTO;
import com.flashj.merchant.service.entity.App;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class AppCovert {

    public static AppDTO entity2dto(App entity) {
        AppDTO appDTO = new AppDTO();
        BeanUtils.copyProperties(entity, appDTO);
        return appDTO;
    }

    public static App dto2entity(AppDTO dto) {
        App app = new App();
        BeanUtils.copyProperties(dto, app);
        return app;
    }

    public static List<AppDTO> listentity2dto(List<App> apps) {
        return apps.parallelStream().map(AppCovert::entity2dto).collect(Collectors.toList());
    }

}
