package zwf.shopping.house.service;

import com.baomidou.mybatisplus.extension.service.IService;

import zwf.shopping.house.entity.FloorListEntity;
import zwf.shopping.house.utils.PageUtils;

import java.util.Map;


public interface FloorListService extends IService<FloorListEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

