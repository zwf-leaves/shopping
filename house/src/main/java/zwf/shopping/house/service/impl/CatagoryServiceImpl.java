package zwf.shopping.house.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import zwf.shopping.house.dao.CatagoryDao;
import zwf.shopping.house.entity.CatagoryEntity;
import zwf.shopping.house.service.CatagoryService;
import zwf.shopping.house.utils.PageUtils;
import zwf.shopping.house.utils.Query;

import java.util.Map;

@Service("catagoryService")
public class CatagoryServiceImpl extends ServiceImpl<CatagoryDao, CatagoryEntity> implements CatagoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CatagoryEntity> page = this.page(
                new Query<CatagoryEntity>().getPage(params),
                new QueryWrapper<CatagoryEntity>()
        );

        return new PageUtils(page);
    }

}