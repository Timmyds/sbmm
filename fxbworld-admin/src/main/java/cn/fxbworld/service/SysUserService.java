package cn.fxbworld.service;

import cn.fxbworld.entity.SysUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
public interface SysUserService extends IService<SysUser> {
	 /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    SysUser findByUserName(String username);
}
