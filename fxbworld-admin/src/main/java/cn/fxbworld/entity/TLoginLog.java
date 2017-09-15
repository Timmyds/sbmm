package cn.fxbworld.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
@TableName("t_login_log")
public class TLoginLog extends BaseModel<TLoginLog> {

    private static final long serialVersionUID = 1L;

	@TableField("login_ip")
	private String loginIp;
	@TableField("login_address")
	private String loginAddress;
    /**
     * 登录方式
     */
	@TableField("login_mode")
	private String loginMode;
	@TableField("login_name")
	private String loginName;
	@TableField("login_date")
	private Date loginDate;


	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getLoginAddress() {
		return loginAddress;
	}

	public void setLoginAddress(String loginAddress) {
		this.loginAddress = loginAddress;
	}

	public String getLoginMode() {
		return loginMode;
	}

	public void setLoginMode(String loginMode) {
		this.loginMode = loginMode;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	

	@Override
	public String toString() {
		return "TLoginLog{" +
			"loginIp=" + loginIp +
			", loginAddress=" + loginAddress +
			", loginMode=" + loginMode +
			", loginName=" + loginName +
			", loginDate=" + loginDate +
			"}";
	}
}
