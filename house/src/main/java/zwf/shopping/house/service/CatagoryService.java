package zwf.shopping.house.service;

import com.baomidou.mybatisplus.extension.service.IService;

import zwf.shopping.house.entity.CatagoryEntity;
import zwf.shopping.house.utils.PageUtils;

import java.util.Map;


public interface CatagoryService extends IService<CatagoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

