package zwf.shopping.house.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import zwf.shopping.house.dao.CatitemsDao;
import zwf.shopping.house.entity.CatitemsEntity;
import zwf.shopping.house.service.CatitemsService;
import zwf.shopping.house.utils.PageUtils;
import zwf.shopping.house.utils.Query;


@Service("catitemsService")
public class CatitemsServiceImpl extends ServiceImpl<CatitemsDao, CatitemsEntity> implements CatitemsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CatitemsEntity> page = this.page(
                new Query<CatitemsEntity>().getPage(params),
                new QueryWrapper<CatitemsEntity>()
        );

        return new PageUtils(page);
    }

}