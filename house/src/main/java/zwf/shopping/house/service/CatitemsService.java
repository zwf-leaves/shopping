package zwf.shopping.house.service;

import com.baomidou.mybatisplus.extension.service.IService;
import zwf.shopping.house.entity.CatitemsEntity;
import zwf.shopping.house.utils.PageUtils;

import java.util.Map;


public interface CatitemsService extends IService<CatitemsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

