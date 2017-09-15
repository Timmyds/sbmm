package cn.fxbworld.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import cn.fxbworld.entity.SysRole;
import cn.fxbworld.entity.SysRoleMenu;
import cn.fxbworld.mapper.SysRoleMapper;
import cn.fxbworld.mapper.SysRoleMenuMapper;
import cn.fxbworld.mapper.SysUserRoleMapper;
import cn.fxbworld.service.SysRoleService;
import cn.fxbworld.vo.JsTreeVM;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
	 @Autowired
	    private SysUserRoleMapper sysUserRoleMapper;

	    @Autowired
	    private SysRoleMenuMapper sysRoleMenuMapper;
	    @Override
	    public List<SysRole> getList(String userId) {
	        List<SysRole> roleList = selectList(new EntityWrapper<>());
	        if (StringUtils.isNotBlank(userId)){
	            List<String> list = sysUserRoleMapper.selectRoleIdsByUserId(userId);
	            for (SysRole role: roleList){
	                if(list.contains(role.getId())){
	                    role.setChecked(true);
	                }
	            }
	        }
	        return roleList;
	    }

	    @Override
	    public boolean insert(SysRole entity) {
	        boolean flag = super.insert(entity);
	        for (JsTreeVM jsTreeVM : entity.getMenuTree()){
	            SysRoleMenu sysRoleMenu = new SysRoleMenu();
	            sysRoleMenu.setRoleId(entity.getId());
	            sysRoleMenu.setMenuId(Long.valueOf(jsTreeVM.getId()));
	            sysRoleMenuMapper.insert(sysRoleMenu);
	        }
	        return flag;
	    }

	    @Override
	    public boolean updateById(SysRole entity) {
	        boolean flag = super.updateById(entity);
	        SysRoleMenu roleMenu = new SysRoleMenu();
	        roleMenu.setRoleId(entity.getId());
	        sysRoleMenuMapper.delete(new EntityWrapper<>(roleMenu));
	        for (JsTreeVM jsTreeVM : entity.getMenuTree()){
	            SysRoleMenu sysRoleMenu = new SysRoleMenu();
	            sysRoleMenu.setRoleId(entity.getId());
	            sysRoleMenu.setMenuId(Long.valueOf(jsTreeVM.getId()));
	            sysRoleMenuMapper.insert(sysRoleMenu);
	        }
	        return flag;
	    }
}
