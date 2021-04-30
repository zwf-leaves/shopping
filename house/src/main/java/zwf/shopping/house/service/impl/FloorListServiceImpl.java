package zwf.shopping.house.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import zwf.shopping.house.dao.FloorListDao;
import zwf.shopping.house.entity.FloorListEntity;
import zwf.shopping.house.service.FloorListService;
import zwf.shopping.house.utils.PageUtils;
import zwf.shopping.house.utils.Query;


@Service("floorListService")
public class FloorListServiceImpl extends ServiceImpl<FloorListDao, FloorListEntity> implements FloorListService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FloorListEntity> page = this.page(
                new Query<FloorListEntity>().getPage(params),
                new QueryWrapper<FloorListEntity>()
        );

        return new PageUtils(page);
    }

}