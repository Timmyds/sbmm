package cn.fxbworld.entity;

import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import cn.fxbworld.vo.JsTreeVM;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
@TableName("sys_role")
public class SysRole extends BaseModel<SysRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
	@TableField("role_name")
	private String roleName;
    /**
     * 备注
     */
	private String remark;

	@TableField(exist=false)
    private Boolean checked;
	@TableField(exist = false)
	private List<JsTreeVM> menuTree;

	public SysRole() {
	}

	public SysRole(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}



	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public List<JsTreeVM> getMenuTree() {
		return menuTree;
	}

	public void setMenuTree(List<JsTreeVM> menuTree) {
		this.menuTree = menuTree;
	}

	@Override
	public String toString() {
		return "SysRole [roleName=" + roleName + ", remark=" + remark + ", checked=" + checked + ", menuTree="
				+ menuTree + "]";
	}
}
