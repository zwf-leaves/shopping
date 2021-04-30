package zwf.shopping.house.service;

import com.baomidou.mybatisplus.extension.service.IService;

import zwf.shopping.house.entity.PicturesEntity;
import zwf.shopping.house.utils.PageUtils;

import java.util.Map;


public interface PicturesService extends IService<PicturesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

