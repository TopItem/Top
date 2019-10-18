package com.top.demo.modules.service;

import com.top.demo.modules.pojo.RolePermissionDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色资源表 服务类
 * </p>
 *
 * @author lth
 * @since 2019-10-17
 */
public interface RolePermissionService extends IService<RolePermissionDO> {

    /**
     * 根据角色的id查询资源代码
     */
    List<String> listByRoleId(Integer id);
}
