package cn.fxbworld.mapper;

import cn.fxbworld.entity.SysRoleMenu;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 角色与菜单关系表 Mapper 接口
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
	 /**
     * 根据角色id查询菜单id
     * @param roleId
     * @return
     */
    List<String> selectMenuIdsByRoleId(Long roleId);
}