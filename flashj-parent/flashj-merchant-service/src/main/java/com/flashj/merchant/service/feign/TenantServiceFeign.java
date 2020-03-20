package com.flashj.merchant.service.feign;

import com.flashj.common.domain.BusinessException;
import com.flashj.common.domain.PageVO;
import com.flashj.user.dto.resource.ApplicationDTO;
import com.flashj.user.dto.tenant.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@author lybbo
*/
@FeignClient(name = "flashj-user-service")
@Component
public interface TenantServiceFeign {

    /**
     * 创建租户
     * 新增租户、新增租户管理员，同时初始化套餐
     * 1.若管理员用户名已存在(目前不会出现，用户名内部随机生成)
     * 2.手机号已存在，禁止创建
     *
     * @param createTenantRequest 创建租户请求信息
     * @return
     */
    @PostMapping("/tenants")
    TenantDTO createTenantAndInit(@RequestBody CreateTenantRequestDTO createTenantRequest);


    /**
     * 创建租户
     * 新增租户、管理到对应管理员，同时初始化套餐
     * 1.若管理员用户名已存在(目前不会出现，用户名内部随机生成)
     * 2.手机号已存在，禁止创建
     *
     * @param createTenantRequest 创建租户请求信息
     * @return
     */
    @PostMapping("/tenantRelateAccount")
    TenantDTO createTenantRelateAccount(@RequestBody CreateTenantRequestDTO createTenantRequest) throws BusinessException;

    /**
     * 获取租户信息
     *
     * @param id
     * @return 租户信息
     */
    @GetMapping("/tenants/{id}")
    TenantDTO getTenant(@PathVariable(value = "id") Long id) throws BusinessException;


    /**
     * 检索租户
     *
     * @param tenantQuery 租户查询条件
     * @param pageNo      查询页
     * @param pageSize    页记录数
     * @param sortBy      排序字段
     * @param order       顺序
     * @return
     */
    @GetMapping("/tenants/page")
    PageVO<TenantDTO> queryTenants(@RequestBody TenantQueryDTO tenantQuery,
                                   @RequestParam(value = "pageNo") Integer pageNo,
                                   @RequestParam(value = "pageSize") Integer pageSize,
                                   @RequestParam(value = "sortBy") String sortBy,
                                   @RequestParam(value = "order") String order) throws BusinessException;


    /**
     * 查询某租户类型的套餐列表(不包含初始化套餐)
     *
     * @param tenantType
     * @return
     */
    @GetMapping("/bundles/tenant-types/{tenantType}/bundle-list")
    List<BundleDTO> queryBundleByTenantType(@PathVariable(value = "tenantType") String tenantType) throws BusinessException;

    /**
     * 获取某套餐信息
     *
     * @param bundleCode 套餐编码
     * @return 套餐信息
     */
    @GetMapping("/bundles/{bundleCode}")
    BundleDTO getBundle(@PathVariable(value = "bundleCode") String bundleCode);

    /**
     * 查询所有套餐
     *
     * @return
     */
    @GetMapping("/bundles/bundle-list")
    List<BundleDTO> queryAllBundle();

    /**
     * 切换租户套餐
     * 租户切换套餐操作会清除原租户内的所有账号-角色关联数据以及原套餐产生的角色权限数据,并将限流规则写入sentinel
     *
     * @param tenantId   租户id
     * @param bundleCode 套餐编码
     */
    @PutMapping("/tenants/{tenantId}/bundles/{bundleCode}")
    void changeBundle(@PathVariable(value = "tenantId") Long tenantId, @PathVariable(value = "bundleCode") String bundleCode) throws BusinessException;

    /**
     * 初始化租户套餐
     * 将限流规则写入sentinel
     *
     * @param tenantId   租户id
     * @param bundleCode 套餐编码
     */
    @PostMapping("/tenants/{tenantId}/bundles/{bundleCode}")
    void initBundle(@PathVariable(value = "tenantId") Long tenantId, @PathVariable(value = "bundleCode") String bundleCode) throws BusinessException;

    /**
     * 新增套餐
     *
     * @param bundleDTO
     */
    @PostMapping("/bundles")
    void createBundle(@RequestBody BundleDTO bundleDTO) throws BusinessException;

    /**
     * 更新套餐
     *
     * @param bundleDTO
     */
    @PutMapping("/bundles")
    void modifyBundle(@RequestBody BundleDTO bundleDTO) throws BusinessException;

    ////////////////////套餐管理end/////////////////////


    /**
     * 创建账号
     * 1.若用户名已存在(目前不会出现，用户名内部随机生成)，禁止创建
     * 2.手机号已存在，禁止创建
     *
     * @param createAccountRequest 创建账号请求
     */
    @PostMapping("/accounts")
    AccountDTO createAccount(@RequestBody CreateAccountRequestDTO createAccountRequest) throws BusinessException;

    /**
     * 创建账号并绑定至某租户
     * 1.若用户名已存在(目前不会出现，用户名内部随机生成)，禁止创建
     * 2.手机号已存在，禁止创建
     *
     * @param createAccountRequest 创建账号请求
     * @param tenantId             租户id
     */
    @PostMapping("/accounts/tenants/{tenantId}")
    void createAccountInTenant(@RequestBody CreateAccountRequestDTO createAccountRequest,
                               @RequestParam(value = "tenantId") Long tenantId) throws BusinessException;

    /**
     * 将已存在账号，加入到某租户（绑定关系，身份不是管理员）
     * 界面上先通过手机号查询到账号信息，再通过账号信息的username，调用此接口，加入租户
     *
     * @param tenantId 租户id
     * @param username 用户名
     */
    @PostMapping("/bind/accounts/{username}/tenants/{tenantId}")
    void bindTenant(@PathVariable(value = "tenantId") Long tenantId, @PathVariable(value = "username") String username) throws BusinessException;

    ///**
    // * 注册时，管理员账号绑定到租户
    // * @param tenantId
    // * @param accountId
    // * @param isAdmin
    // * @throws BusinessException
    // */
    //void bindTenantAccount(Long tenantId, Long accountId,Boolean isAdmin) throws BusinessException;


    /**
     * 将某账号从租户内移除，租户管理员不可移除
     *
     * @param tenantId 租户id
     * @param username 用户名
     */
    @DeleteMapping("/unbind/accounts/{username}/tenants/{tenantId}")
    void unbindTenant(@PathVariable(value = "tenantId") Long tenantId,
                      @PathVariable(value = "username") String username)
            throws BusinessException;

    /**
     * 根据用户名判断账号是否存在
     *
     * @param username 用户名
     * @return
     */
    @GetMapping("/exist/accounts/name/{username}")
    boolean isExistAccountByUsername(@PathVariable(value = "username") String username) throws BusinessException;

    /**
     * 根据手机号判断账号是否存在
     *
     * @param mobile 手机号
     * @return
     */
    @GetMapping("/exist/accounts/mobile/{mobile}")
    boolean isExistAccountByMobile(@PathVariable(value = "mobile") String mobile) throws BusinessException;


    /**
     * 根据用户名获取账号信息
     *
     * @param username 用户名
     * @return 账号信息
     */
    @GetMapping("/account-information/name/{username}")
    AccountDTO getAccountByUsername(@PathVariable(value = "username") String username) throws BusinessException;

    /**
     * 根据手机号获取账号信息
     *
     * @param mobile 手机号
     * @return 账号信息
     */
    @GetMapping("/accounts-information/mobile/{mobile}")
    AccountDTO getAccountByMobile(@PathVariable(value = "mobile") String mobile) throws BusinessException;


    /**
     * 根据用户名判断账号是否在某租户内
     *
     * @param tenantId 租户id
     * @param username 用户名
     * @return
     */
    @GetMapping("/exist/accounts/{username}/tenants/{tenantId}")
    boolean isExistAccountInTenantByUsername(@PathVariable(value = "tenantId") Long tenantId,
                                             @PathVariable(value = "username") String username) throws BusinessException;

    /**
     * 根据手机号判断账号是否在某租户内
     *
     * @param tenantId 租户id
     * @param mobile   手机号
     * @return
     */
    @GetMapping("/exist/accounts/tenants/{tenantId}/mobiles/{mobile}")
    boolean isExistAccountInTenantByMobile(@PathVariable(value = "tenantId") Long tenantId,
                                           @PathVariable(value = "mobile") String mobile) throws BusinessException;

    /**
     * 检索账号
     *
     * @param accountQuery 账号查询条件
     * @param pageNo       查询页
     * @param pageSize     页记录数
     * @param sortBy       排序字段
     * @param order        顺序
     * @return
     */
    @GetMapping("/accounts/page")
    PageVO<AccountDTO> queryAccount(@RequestBody AccountQueryDTO accountQuery,
                                    @RequestParam(value = "pageNo") Integer pageNo,
                                    @RequestParam(value = "pageSize") Integer pageSize,
                                    @RequestParam(value = "sortBy") String sortBy,
                                    @RequestParam(value = "order") String order) throws BusinessException;


    /**
     * 查询某账号所属租户列表
     *
     * @param username 用户名
     * @return
     */
    @GetMapping("/accounts/tenant-list/{username}")
    List<TenantDTO> queryAccountInTenant(@PathVariable(value = "username") String username) throws BusinessException;

    /**
     * 发送短信验证码
     *
     * @param phone
     * @return
     */
    @GetMapping("/getMessage")
    String sendMessage(@RequestParam(value = "phone") String phone);

    /**
     * 用户认证
     *
     * @param authenticationInfo 认证请求信息
     * @return 认证成功的账号信息
     */
    @GetMapping("/authentication")
    AccountDTO authentication(@RequestBody AuthenticationInfo authenticationInfo) throws BusinessException;


    /**
     * 用户登录，被uaa服务调用并生成令牌
     * 1.调用authentication(AuthenticationInfo authenticationInfo)认证接口通过认证
     * 2.调用queryAccountInTenant(String username)获取该用户所属租户列表
     * 3.授权，调用AuthorizationService.authorize(String username, Long[] tenantIds)获取该用户在多个租户下的权限
     * 4.获取资源,调用loadResources(Map<Long, AuthorizationInfoDTO> tenantAuthorizationInfMap);，获取该用户在多个租户下的资源
     *
     * @param loginRequest 登录请求
     * @param loginRequest
     * @return
     * @throws BusinessException
     */
    @GetMapping("/login")
    LoginInfoDTO login(@RequestBody LoginRequestDTO loginRequest) throws BusinessException;

    /**
     * 根据接入客户端获取应用
     *
     * @param clientId
     * @return
     * @throws BusinessException
     */
    @GetMapping("/apps/{clientId}")
    ApplicationDTO getApplicationDTOByClientId(@PathVariable(value = "clientId") String clientId) throws BusinessException;
}
