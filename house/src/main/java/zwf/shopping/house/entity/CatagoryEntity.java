package zwf.shopping.house.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


@Data
@TableName("catagory")
public class CatagoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 分类id
	 */
	@TableId
	private Integer catId;
	/**
	 * 分类name
	 */
	private String catName;
	/**
	 * 图标
	 */
	private String catIcon;
	/**
	 * 父id
	 */
	private Integer catPid;
	/**
	 * 分类等级
	 */
	private Integer catLevel;
	/**
	 *
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@TableField(exist = false)
	private List<CatagoryEntity> children;

}
