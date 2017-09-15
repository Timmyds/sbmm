package cn.fxbworld.entity;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
@TableName("sys_user")
public class SysUser extends BaseModel<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 登录名
     */
	@TableField("login_name")
	private String loginName;
    /**
     * 用户名
     */
	private String username;
    /**
     * 密码
     */
	private String password;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 手机号
     */
	private String mobile;
	@TableField("login_ip")
	private String loginIp;
	@TableField("login_count")
	private Long loginCount;
    /**
     * 登录时间
     */
	@TableField("login_time")
	private Date loginTime;
	private String status;

	@TableField(exist = false)
	private List<SysRole> rolelist;

	public SysUser(String username) {
		this.username = username;
	}

	public SysUser() {
	}
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Long getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Long loginCount) {
		this.loginCount = loginCount;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public List<SysRole> getRolelist() {
		return rolelist;
	}

	public void setRolelist(List<SysRole> rolelist) {
		this.rolelist = rolelist;
	}

	@Override
	public String toString() {
		return "SysUser [loginName=" + loginName + ", username=" + username + ", password=" + password + ", email="
				+ email + ", mobile=" + mobile + ", loginIp=" + loginIp + ", loginCount=" + loginCount + ", loginTime="
				+ loginTime + ", status=" + status + ", rolelist=" + rolelist + "]";
	}


}
