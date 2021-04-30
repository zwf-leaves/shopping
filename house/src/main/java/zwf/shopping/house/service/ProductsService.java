package zwf.shopping.house.service;

import com.baomidou.mybatisplus.extension.service.IService;

import zwf.shopping.house.entity.ProductsEntity;
import zwf.shopping.house.utils.PageUtils;

import java.util.Map;


public interface ProductsService extends IService<ProductsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

