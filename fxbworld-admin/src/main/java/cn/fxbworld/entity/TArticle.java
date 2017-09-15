package cn.fxbworld.entity;

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
@TableName("t_article")
public class TArticle extends BaseModel<TArticle> {

    private static final long serialVersionUID = 1L;

    /**
     * 主题
     */
	private String theme;
	private Integer category;
    /**
     * 文章分类
     */
	@TableField("article_type")
	private Integer articleType;
    /**
     * 内容
     */
	private String content;
    /**
     * 状态
     */
	private Integer status;
	private String cover2;
	private String cover3;
	private String cover1;
    /**
     * 封面内容
     */
	@TableField("cover_type")
	private Integer coverType;
	@TableField("click_num")
	private Long clickNum;


	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Integer getArticleType() {
		return articleType;
	}

	public void setArticleType(Integer articleType) {
		this.articleType = articleType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCover2() {
		return cover2;
	}

	public void setCover2(String cover2) {
		this.cover2 = cover2;
	}

	public String getCover3() {
		return cover3;
	}

	public void setCover3(String cover3) {
		this.cover3 = cover3;
	}

	public String getCover1() {
		return cover1;
	}

	public void setCover1(String cover1) {
		this.cover1 = cover1;
	}

	public Integer getCoverType() {
		return coverType;
	}

	public void setCoverType(Integer coverType) {
		this.coverType = coverType;
	}

	public Long getClickNum() {
		return clickNum;
	}

	public void setClickNum(Long clickNum) {
		this.clickNum = clickNum;
	}



	@Override
	public String toString() {
		return "TArticle{" +
			"theme=" + theme +
			", category=" + category +
			", articleType=" + articleType +
			", content=" + content +
			", status=" + status +
			", cover2=" + cover2 +
			", cover3=" + cover3 +
			", cover1=" + cover1 +
			", coverType=" + coverType +
			", clickNum=" + clickNum +
			"}";
	}
}
