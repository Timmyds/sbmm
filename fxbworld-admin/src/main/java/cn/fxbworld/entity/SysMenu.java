package cn.fxbworld.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 菜单管理
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
@TableName("sys_menu")
public class SysMenu extends BaseModel<SysMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 父菜单ID
     */
	@TableField("parent_id")
	private Long parentId;
    /**
     * 菜单名称
     */
	private String name;
    /**
     * 类型
     */
	private String type;
    /**
     * 菜单图标
     */
	private String icon;
    /**
     * 菜单标题
     */
	private String title;
    /**
     * 菜单层级
     */
	private Integer level;
    /**
     * 菜单编码
     */
	private String funcode;
    /**
     * 状态1：正常 0：关闭
     */
	private Integer status;
    /**
     * 菜单路径
     */
	@TableField("menu_path")
	private String menuPath;
    /**
     * 排序
     */
	private Integer order;


	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getFuncode() {
		return funcode;
	}

	public void setFuncode(String funcode) {
		this.funcode = funcode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMenuPath() {
		return menuPath;
	}

	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "SysMenu [parentId=" + parentId + ", name=" + name + ", type=" + type + ", icon=" + icon + ", title="
				+ title + ", level=" + level + ", funcode=" + funcode + ", status=" + status + ", menuPath=" + menuPath
				+ ", order=" + order + "]";
	}



}
