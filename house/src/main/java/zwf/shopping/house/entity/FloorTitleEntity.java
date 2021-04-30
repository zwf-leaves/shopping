package zwf.shopping.house.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
@TableName("floor_title")
public class FloorTitleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 楼层标题id
	 */
	@TableId
	private Integer titleId;
	/**
	 * 商品分类id
	 */
	private Integer catId;
	/**
	 * 标题name
	 */
	private String name;
	/**
	 * 图片路径
	 */
	private String imageSrc;

}
