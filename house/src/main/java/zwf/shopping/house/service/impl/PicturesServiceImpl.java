package zwf.shopping.house.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import zwf.shopping.house.dao.PicturesDao;
import zwf.shopping.house.entity.PicturesEntity;
import zwf.shopping.house.service.PicturesService;
import zwf.shopping.house.utils.PageUtils;
import zwf.shopping.house.utils.Query;

import java.util.Map;

@Service("picturesService")
public class PicturesServiceImpl extends ServiceImpl<PicturesDao, PicturesEntity> implements PicturesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PicturesEntity> page = this.page(
                new Query<PicturesEntity>().getPage(params),
                new QueryWrapper<PicturesEntity>()
        );

        return new PageUtils(page);
    }

}