package zwf.shopping.house.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
@TableName("floor_list")
public class FloorListEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 列表id
	 */
	@TableId
	private Integer lilstId;
	/**
	 * 楼层标题id
	 */
	private Integer titleId;
	/**
	 * 属性name
	 */
	private String name;
	/**
	 * 图片路径
	 */
	private String imageSrc;
	/**
	 * 图片宽度
	 */
	private Integer imageWidth;
	/**
	 * 打开方式
	 */
	private String openType;
	/**
	 * 跳转连接
	 */
	private String navigatorUrl;

}
