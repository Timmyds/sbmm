package cn.fxbworld.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 角色与菜单关系表
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
@TableName("sys_role_menu")
public class SysRoleMenu extends BaseModel<SysRoleMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
	@TableField("role_id")
	private Long roleId;
    /**
     * 菜单ID
     */
	@TableField("menu_id")
	private Long menuId;

	
	public SysRoleMenu(Long menuId) {
		this.menuId = menuId;
	}

	public SysRoleMenu() {
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}


	@Override
	public String toString() {
		return "SysRoleMenu{" +
			"roleId=" + roleId +
			", menuId=" + menuId +
			"}";
	}
}
