package cn.fxbworld.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 用户与角色关系表
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
@TableName("sys_user_role")
public class SysUserRole extends BaseModel<SysUserRole> {

	private static final long serialVersionUID = 1L;

	/**
	 * 角色ID
	 */
	@TableField("role_id")
	private Long roleId;

	/**
	 * 角色ID
	 */
	@TableField("user_id")
	private Long userId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "SysUserRole [roleId=" + roleId + ", userId=" + userId + "]";
	}
}
