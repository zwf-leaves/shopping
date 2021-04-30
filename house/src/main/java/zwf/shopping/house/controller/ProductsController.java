package zwf.shopping.house.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import zwf.shopping.house.entity.PicturesEntity;
import zwf.shopping.house.entity.ProductsEntity;
import zwf.shopping.house.service.PicturesService;
import zwf.shopping.house.service.ProductsService;
import zwf.shopping.house.utils.PageUtils;
import zwf.shopping.house.utils.R;
import zwf.shopping.house.vo.GoodsDetialVo;
import zwf.shopping.house.vo.SwiperdataVo;


@RestController
@RequestMapping("house/products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;
    @Autowired
    private PicturesService picturesService;

    /**
     * 首页热点轮播数据
     */
    @RequestMapping("/swiperdata")
    public R swiperdata(){
        List<ProductsEntity> productsEntities = productsService.list();

        ArrayList<SwiperdataVo> swiperdataVos = new ArrayList<>();
        if(productsEntities.size()>=3){
            for (int i = 0; i < 3; i++) {
                SwiperdataVo swiperdata = new SwiperdataVo();
                swiperdata.setGoods_id(productsEntities.get(i).getGoodsId());
                swiperdata.setImage_src(productsEntities.get(i).getGoodsImg());
                swiperdata.setNavigator_url("/pages/goods_detail/index?goodsId="+productsEntities.get(i).getGoodsId());
                swiperdata.setOpen_type("navigate");
                swiperdataVos.add(swiperdata);
            }
        }else {
            for (int i = 0; i < productsEntities.size(); i++) {
                SwiperdataVo swiperdata = new SwiperdataVo();
                swiperdata.setGoods_id(productsEntities.get(i).getGoodsId());
                swiperdata.setImage_src(productsEntities.get(i).getGoodsImg());
                swiperdata.setNavigator_url("/pages/goods_detail/index?goods_id="+productsEntities.get(i).getGoodsId());
                swiperdata.setOpen_type("navigate");
                swiperdataVos.add(swiperdata);
            }
        }

        return R.ok().put("message", swiperdataVos);
    }

    /**
     * 商品列表搜索
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productsService.queryPage(params);
        return R.ok().put("message", page);
    }


    /**
     * 详情信息
     */
    @RequestMapping("/getProduct")
    public R info(@RequestParam("goodsId") Integer goodsId){
        GoodsDetialVo goodsDetialVo = new GoodsDetialVo();
        ProductsEntity products = productsService.getById(goodsId);
        BeanUtils.copyProperties(products,goodsDetialVo);
        List<PicturesEntity> picturesEntities = picturesService.list(new QueryWrapper<PicturesEntity>().eq("goods_id", products.getGoodsId()));
        goodsDetialVo.setPics(picturesEntities);
        return R.ok().put("message", goodsDetialVo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ProductsEntity products){
		productsService.save(products);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ProductsEntity products){
		productsService.updateById(products);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] goodsIds){
		productsService.removeByIds(Arrays.asList(goodsIds));
        return R.ok();
    }

}
