package cn.fxbworld.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import cn.fxbworld.entity.SysMenu;
import cn.fxbworld.entity.SysRoleMenu;
import cn.fxbworld.mapper.SysMenuMapper;
import cn.fxbworld.mapper.SysRoleMenuMapper;
import cn.fxbworld.service.SysMenuService;
import cn.fxbworld.util.MenuTreeUtil;
import cn.fxbworld.vo.JsTreeVM;
import cn.fxbworld.vo.MenuVM;
import cn.fxbworld.vo.TreeStateVM;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
	 @Autowired
	    private SysRoleMenuMapper sysRoleMenuMapper;

	    @Override
	    public List<JsTreeVM> getMenuTree(Long roleId) {
	        List<JsTreeVM> treeVoList = new ArrayList<>();
	        EntityWrapper<SysMenu> wrapper = new EntityWrapper<SysMenu>();
	        wrapper.orderBy("sys_menu.order");
	        List<SysMenu> menuList = selectList(wrapper);
	        List<String> menuIds = new ArrayList<>();
	        if (roleId!=null) {
	            menuIds = sysRoleMenuMapper.selectMenuIdsByRoleId(roleId);
	        }
	        for (SysMenu sysMenu : menuList) {
	            JsTreeVM jsTreeVM = new JsTreeVM();
	            jsTreeVM.setId(sysMenu.getId().toString());
	            jsTreeVM.setParent(sysMenu.getParentId()==null||sysMenu.getParentId()==0?"#":sysMenu.getParentId().toString());
	            jsTreeVM.setText(sysMenu.getTitle());
	            jsTreeVM.setIcon(sysMenu.getIcon());
	            TreeStateVM state = new TreeStateVM();
	            if (menuIds.size()>0&&menuIds.contains(sysMenu.getId())){
	                state.setSelected(true);
	            }
	            jsTreeVM.setState(state);
	            treeVoList.add(jsTreeVM);
	        }
	        return treeVoList;
	    }

	    @Override
	    public boolean insert(SysMenu entity) {
	        boolean flag = super.insert(entity);

	        //自动分配给拥有父菜单的角色权限
	        List<SysRoleMenu> roleMenuList = sysRoleMenuMapper.selectList(
	                new EntityWrapper<>(new SysRoleMenu(entity.getParentId())));
	        for (SysRoleMenu roleMenu: roleMenuList){
	            SysRoleMenu sysRoleMenu = new SysRoleMenu();
	            sysRoleMenu.setMenuId(entity.getId());
	            sysRoleMenu.setRoleId(roleMenu.getRoleId());
	            sysRoleMenuMapper.insert(sysRoleMenu);
	        }
	        return flag;
	    }

	    @Override
	    public Set<String> getPermissions(Long userId) {

	        List<String> menuList = baseMapper.getPermissions(userId);
	        //用户权限列表
	        Set<String> permsSet = new HashSet<String>();
	        for(String perm : menuList){
	            if(StringUtils.isBlank(perm)){
	                continue;
	            }
	            permsSet.addAll(Arrays.asList(perm.trim().split(",")));
	        }
	        return permsSet;
	    }

	    @Override
	    public List<MenuVM> getMenu(Long userId) {
	        List<SysMenu> menuList = baseMapper.selectMenuByUserId(userId);
	        return MenuTreeUtil.getMenu(menuList);
	    }
}
