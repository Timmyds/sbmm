package cn.fxbworld.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
@TableName("tb_dict")
public class TbDict extends BaseModel<TbDict> {

    private static final long serialVersionUID = 1L;

	private String code;
	private String text;
	private String remark;
	@TableField("dict_class_id")
	private String dictClassId;


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDictClassId() {
		return dictClassId;
	}

	public void setDictClassId(String dictClassId) {
		this.dictClassId = dictClassId;
	}

	

	@Override
	public String toString() {
		return "TbDict{" +
			"code=" + code +
			", text=" + text +
			", remark=" + remark +
			", dictClassId=" + dictClassId +
			"}";
	}
}
