package zwf.shopping.house.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;

@Data
@TableName("catItems")
public class CatitemsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 导航id
	 */
	@TableId
	private Integer id;
	/**
	 * 导航name
	 */
	private String name;
	/**
	 * 导航图标
	 */
	private String imageSrc;
	/**
	 * 跳转连接
	 */
	private String navigatorUrl;

}
