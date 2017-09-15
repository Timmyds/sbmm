package cn.fxbworld.entity;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * todo表
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
@TableName("tb_todo")
public class TbTodo extends BaseModel<TbTodo> {

    private static final long serialVersionUID = 1L;

	private String text;


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	

	@Override
	public String toString() {
		return "TbTodo{" +
			"text=" + text +
			"}";
	}
}
