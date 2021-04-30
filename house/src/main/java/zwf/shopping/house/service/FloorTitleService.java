package zwf.shopping.house.service;

import com.baomidou.mybatisplus.extension.service.IService;

import zwf.shopping.house.entity.FloorTitleEntity;
import zwf.shopping.house.utils.PageUtils;

import java.util.Map;


public interface FloorTitleService extends IService<FloorTitleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

