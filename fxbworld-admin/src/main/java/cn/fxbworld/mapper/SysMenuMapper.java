package cn.fxbworld.mapper;

import cn.fxbworld.entity.SysMenu;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 菜单管理 Mapper 接口
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
	/**
     * 根据用户id获取菜单
     * @param userId
     * @return
     */
    List<SysMenu> selectMenuByUserId(Long userId);

    /**
     * 根据用户id查询权限
     * @param userId
     * @return
     */
    List<String> getPermissions(Long userId);
}