package cn.fxbworld.service;

import cn.fxbworld.entity.SysRole;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
public interface SysRoleService extends IService<SysRole> {
	/**
     * 根据用户id查询角色集合
     * @param userId
     * @return
     */
    List<SysRole> getList(String userId);
}
