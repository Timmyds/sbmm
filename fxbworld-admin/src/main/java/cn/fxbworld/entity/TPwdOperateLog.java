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
@TableName("t_pwd_operate_log")
public class TPwdOperateLog extends BaseModel<TPwdOperateLog> {

    private static final long serialVersionUID = 1L;

	@TableField("operate_ip")
	private String operateIp;
	@TableField("operate_address")
	private String operateAddress;
	@TableField("operate_mode")
	private String operateMode;
	@TableField("login_name")
	private String loginName;
	@TableField("operate_date")
	private Date operateDate;
	@TableField("operate_user_name")
	private String operateUserName;
	@TableField("operate_user_id")
	private Long operateUserId;


	public String getOperateIp() {
		return operateIp;
	}

	public void setOperateIp(String operateIp) {
		this.operateIp = operateIp;
	}

	public String getOperateAddress() {
		return operateAddress;
	}

	public void setOperateAddress(String operateAddress) {
		this.operateAddress = operateAddress;
	}

	public String getOperateMode() {
		return operateMode;
	}

	public void setOperateMode(String operateMode) {
		this.operateMode = operateMode;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	public String getOperateUserName() {
		return operateUserName;
	}

	public void setOperateUserName(String operateUserName) {
		this.operateUserName = operateUserName;
	}

	public Long getOperateUserId() {
		return operateUserId;
	}

	public void setOperateUserId(Long operateUserId) {
		this.operateUserId = operateUserId;
	}

	

	@Override
	public String toString() {
		return "TPwdOperateLog{" +
			"operateIp=" + operateIp +
			", operateAddress=" + operateAddress +
			", operateMode=" + operateMode +
			", loginName=" + loginName +
			", operateDate=" + operateDate +
			", operateUserName=" + operateUserName +
			", operateUserId=" + operateUserId +
			"}";
	}
}
