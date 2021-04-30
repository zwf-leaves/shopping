package zwf.shopping.house.vo;

import lombok.Data;

/**
 * @author zwf
 * @create 2021-04-10-13:09
 */
@Data
public class SwiperdataVo {
    /**
     * 图片路径
     */
    private String image_src;
    /**
     * 打开方式
     */
    private String open_type;
    /**
     * 商品id
     */
    private int goods_id;
    /**
     * 导航链接
     */
    private String navigator_url;
}
