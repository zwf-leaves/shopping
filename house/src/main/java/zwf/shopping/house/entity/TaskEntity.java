package zwf.shopping.house.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@TableName("task")
public class TaskEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 预约人姓名
	 */
	private String name;
	/**
	 * 预约人电话
	 */
	private String phone;
	/**
	 * 预约时间
	 */
	private Date date;
	/**
	 * 性别
	 */
	private char sex;
	/**
	 * 预约人姓名
	 */
	private String goodsName;
	/**
	 * 预约人姓名
	 */
	private String address;
	/**
	 * 预约人姓名
	 */
	private String nickName;

}
