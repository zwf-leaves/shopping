package zwf.shopping.house.vo;

import lombok.Data;
import zwf.shopping.house.entity.PicturesEntity;

import java.util.Date;
import java.util.List;

/**
 * @author zwf
 * @create 2021-04-13-15:38
 */
@Data
public class GoodsDetialVo {
    /**
     * 商品id
     */
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
    /**
     * 商品图片信息
     */
    private List<PicturesEntity> pics;
}
