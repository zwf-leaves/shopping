package zwf.shopping.house.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import zwf.shopping.house.dao.FloorTitleDao;
import zwf.shopping.house.entity.FloorTitleEntity;
import zwf.shopping.house.service.FloorTitleService;
import zwf.shopping.house.utils.PageUtils;
import zwf.shopping.house.utils.Query;


@Service("floorTitleService")
public class FloorTitleServiceImpl extends ServiceImpl<FloorTitleDao, FloorTitleEntity> implements FloorTitleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FloorTitleEntity> page = this.page(
                new Query<FloorTitleEntity>().getPage(params),
                new QueryWrapper<FloorTitleEntity>()
        );

        return new PageUtils(page);
    }

}