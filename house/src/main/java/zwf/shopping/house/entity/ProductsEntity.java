package zwf.shopping.house.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
@TableName("products")
public class ProductsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品id
	 */
	@TableId
	private Integer goodsId;
	/**
	 * 分类id
	 */
	private Integer catId;
	/**
	 * 商品name
	 */
	private String goodsName;
	/**
	 * 商品price
	 */
	private Double goodsPrice;
	/**
	 * 商品图片
	 */
	private String goodsImg;
	/**
	 * 商品简介
	 */
	private String goodsIntroduce;
	/**
	 * 添加时间
	 */
	private Date addTime;
	/**
	 * 更新时间
	 */
	private Date updTime;
	/**
	 * 热度
	 */
	private Integer hotMumber;
	/**
	 * 关键字查询
	 */
	private String query;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 折扣
	 */
	private double discount;

}
