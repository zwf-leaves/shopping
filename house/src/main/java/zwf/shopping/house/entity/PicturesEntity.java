package zwf.shopping.house.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName("pictures")
public class PicturesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 图片id
	 */
	@TableId
	private Integer picsId;
	/**
	 * 商品id
	 */
	private Integer goodsId;
	/**
	 * 图片地址
	 */
	private String picsUrl;

}
