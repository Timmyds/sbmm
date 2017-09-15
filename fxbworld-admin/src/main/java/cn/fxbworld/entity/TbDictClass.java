package cn.fxbworld.entity;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 字典分类表
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
@TableName("tb_dict_class")
public class TbDictClass extends BaseModel<TbDictClass> {

    private static final long serialVersionUID = 1L;

	private String code;
	private String remark;


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	@Override
	public String toString() {
		return "TbDictClass{" +
			"code=" + code +
			", remark=" + remark +
			"}";
	}
}
