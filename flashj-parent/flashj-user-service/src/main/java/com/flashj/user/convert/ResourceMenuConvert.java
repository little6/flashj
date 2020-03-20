package com.flashj.user.convert;

import com.flashj.user.dto.menu.MenuDTO;
import com.flashj.user.entity.ResourceMenu;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ResourceMenuConvert {

    public static MenuDTO entity2dto(ResourceMenu entity) {
        MenuDTO menuDTO = new MenuDTO();
        BeanUtils.copyProperties(entity, menuDTO);
        return menuDTO;
    }

    public static ResourceMenu dto2entity(MenuDTO dto) {
        ResourceMenu resourceMenu = new ResourceMenu();
        BeanUtils.copyProperties(dto, resourceMenu);
        return resourceMenu;
    }

    public static List<MenuDTO> entitylist2dto(List<ResourceMenu> resourceMenus) {
        return resourceMenus.stream().map(ResourceMenuConvert::entity2dto).collect(Collectors.toList());
    }

    public static List<ResourceMenu> dtolist2entity(List<MenuDTO> menuDTOs) {
        return menuDTOs.stream().map(ResourceMenuConvert::dto2entity).collect(Collectors.toList());
    }

}
