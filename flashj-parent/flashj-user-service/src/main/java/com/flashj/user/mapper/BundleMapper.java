package com.flashj.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flashj.user.entity.Bundle;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 *
 * @since 2019-08-13
 */
@Repository
public interface BundleMapper extends BaseMapper<Bundle> {

    //@Select("select * from bundle where CODE=#{bundleCode}")
    //Bundle selectBundleByCode(@Param("bundleCode") String bundleCode);

}
