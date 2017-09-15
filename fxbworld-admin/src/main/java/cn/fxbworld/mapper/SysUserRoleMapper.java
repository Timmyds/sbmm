package cn.fxbworld.mapper;

import cn.fxbworld.entity.SysUserRole;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 用户与角色关系表 Mapper 接口
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
	/**
	 * 根据用户id查询角色id集合
	 * 
	 * @param userId
	 * @return
	 */
	List<String> selectRoleIdsByUserId(String userId);
}