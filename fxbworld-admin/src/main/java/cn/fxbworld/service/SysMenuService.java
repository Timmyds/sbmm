package cn.fxbworld.service;

import cn.fxbworld.entity.SysMenu;
import cn.fxbworld.vo.JsTreeVM;
import cn.fxbworld.vo.MenuVM;

import java.util.List;
import java.util.Set;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
public interface SysMenuService extends IService<SysMenu> {
	/**
     * 根据角色id获取菜单树
     * @param roleId
     * @return
     */
    List<JsTreeVM> getMenuTree(Long roleId);

    /**
     * 根据用户id获取权限集合
     * @param userId
     * @return
     */
    Set<String> getPermissions(Long userId);

    /**
     * 根据用户id获取菜单
     * @param userId
     * @return
     */
    List<MenuVM> getMenu(Long userId);
}
