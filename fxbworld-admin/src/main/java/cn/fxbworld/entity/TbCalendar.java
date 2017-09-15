package cn.fxbworld.entity;

import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 日历备忘表
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
@TableName("tb_calendar")
public class TbCalendar extends BaseModel<TbCalendar> {

    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
	private String title;
    /**
     * 开始时间
     */
	private String start;
    /**
     * 结束时间
     */
	private String end;
    /**
     * 颜色
     */
	private String color;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	

	@Override
	public String toString() {
		return "TbCalendar{" +
			"title=" + title +
			", start=" + start +
			", end=" + end +
			", color=" + color +
			"}";
	}
}
