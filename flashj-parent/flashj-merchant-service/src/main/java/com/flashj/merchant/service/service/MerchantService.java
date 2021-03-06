package com.flashj.merchant.service.service;

import com.flashj.common.domain.BusinessException;
import com.flashj.common.domain.PageVO;
import com.flashj.merchant.service.dto.MerchantDTO;
import com.flashj.merchant.service.dto.StaffDTO;
import com.flashj.merchant.service.dto.StoreDTO;

import java.util.List;

public interface MerchantService {

    /**
     * 根据 商户id查询商户
     *
     * @param id 商户id
     * @return
     */
    MerchantDTO queryMerchantById(Long id);

    /**
     * 查询商户列表
     * @return List<MerchantDTO>
     */
    List<MerchantDTO> queryMerchants();

    /**
     * 根据租户id查询商户的信息
     *
     * @param tenantId 租户id
     * @return MerchantDTO
     */
    MerchantDTO queryMerchantByTenantId(Long tenantId);

    /**
     * 注册商户服务接口，接收账号、密码、手机号，为了可扩展性使用merchantDto接收数据
     *
     * @param merchantDTO 商户注册信息
     * @return 注册成功的商户信息
     */
    MerchantDTO createMerchant(MerchantDTO merchantDTO) throws BusinessException;

    /**
     * 资质申请接口
     *
     * @param merchantId  商户id
     * @param merchantDTO 资质申请的信息
     * @throws BusinessException 业务异常
     */
    void applyMerchant(Long merchantId, MerchantDTO merchantDTO) throws BusinessException;


    /**
     * 新增门店
     *
     * @param storeDTO 门店信息
     * @return 新增成功的门店信息
     * @throws BusinessException 业务异常
     */
    StoreDTO createStore(StoreDTO storeDTO) throws BusinessException;


    /**
     * 新增员工
     *
     * @param staffDTO 员工信息
     * @return 新增成功的员工信息
     * @throws BusinessException 业务异常
     */
    StaffDTO createStaff(StaffDTO staffDTO) throws BusinessException;


    /**
     * 将员工设置为门店的管理员
     *
     * @param storeId 门店id
     * @param staffId 员工id
     * @throws BusinessException 业务异常
     */
    void bindStaffToStore(Long storeId, Long staffId) throws BusinessException;

    /**
     * 门店列表的查询
     *
     * @param storeDTO 查询条件，必要参数：商户id
     * @param pageNo   页码
     * @param pageSize 分页记录数
     * @return PageVO<StoreDTO>
     */
    PageVO<StoreDTO> queryStoreByPage(StoreDTO storeDTO, Integer pageNo, Integer pageSize);

    /**
     * 校验门店是否属于商户
     *
     * @param StoreId    门店id
     * @param merchantId 商户id
     * @return Boolean
     */
    Boolean queryStoreInMerchant(Long StoreId, Long merchantId);
}
