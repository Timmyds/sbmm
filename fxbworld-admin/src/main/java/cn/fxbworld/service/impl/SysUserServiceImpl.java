package cn.fxbworld.service.impl;

import java.util.List;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import cn.fxbworld.entity.SysRole;
import cn.fxbworld.entity.SysUser;
import cn.fxbworld.entity.SysUserRole;
import cn.fxbworld.mapper.SysUserMapper;
import cn.fxbworld.mapper.SysUserRoleMapper;
import cn.fxbworld.service.SysUserService;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;

	@Override
	public boolean insert(SysUser entity) {
		String password = new Sha256Hash(entity.getPassword()).toHex();
		entity.setPassword(password);
		boolean flag = super.insert(entity);
		if (entity.getRolelist() != null && entity.getRolelist().size() > 0) {
			for (SysRole role : entity.getRolelist()) {
				if (role.getChecked() != null && role.getChecked()) {
					SysUserRole sysUserRole = new SysUserRole();
					sysUserRole.setUserId(entity.getId());
					sysUserRole.setRoleId(role.getId());
					sysUserRoleMapper.insert(sysUserRole);
				}
			}
		}
		return flag;
	}

	@Override
	public boolean updateById(SysUser entity) {
		boolean flag = super.updateById(entity);
		SysUserRole userRole = new SysUserRole();
		userRole.setUserId(entity.getId());
		if (entity.getRolelist() != null && entity.getRolelist().size() > 0) {
			sysUserRoleMapper.delete(new EntityWrapper<>(userRole));
			if (entity.getRolelist() != null) {
				for (SysRole role : entity.getRolelist()) {
					if (role.getChecked() != null && role.getChecked()) {
						SysUserRole sysUserRole = new SysUserRole();
						sysUserRole.setUserId(entity.getId());
						sysUserRole.setRoleId(role.getId());
						sysUserRoleMapper.insert(sysUserRole);
					}
				}
			}
		}
		return flag;
	}

	@Override
	public SysUser findByUserName(String username) {
		List<SysUser> list = selectList(new EntityWrapper<>(new SysUser(username)));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
