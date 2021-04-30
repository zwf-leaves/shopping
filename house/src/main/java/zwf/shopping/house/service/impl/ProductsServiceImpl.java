package zwf.shopping.house.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import org.springframework.util.StringUtils;
import zwf.shopping.house.dao.ProductsDao;
import zwf.shopping.house.entity.ProductsEntity;
import zwf.shopping.house.service.ProductsService;
import zwf.shopping.house.utils.PageUtils;
import zwf.shopping.house.utils.Query;


@Service("productsService")
public class ProductsServiceImpl extends ServiceImpl<ProductsDao, ProductsEntity> implements ProductsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<ProductsEntity> wrapper = new QueryWrapper<>();
        String query = (String)params.get("query");
        String cid = (String)params.get("cid");
        String date = (String)params.get("date");
        String discount = (String)params.get("discount");
        String hotMumber = (String)params.get("hotMumber");
        if(!StringUtils.isEmpty(query)){
            wrapper.or((obj)->{
                obj.like("query",query).or().like("goods_name",query);
            });
        }
        if(!StringUtils.isEmpty(cid)){
            wrapper.or((obj)->{
                obj.like("cat_id",cid);
            });
        }
        if(!StringUtils.isEmpty(date)){
            wrapper.
               orderByDesc("add_time");
        }
        if(!StringUtils.isEmpty(discount)){
            wrapper.or((obj)->{
                obj.lt("discount",1);
            });
        }
        if(!StringUtils.isEmpty(hotMumber)){
            wrapper.orderByDesc("hot_mumber");

        }
        IPage<ProductsEntity> page = this.page(
                new Query<ProductsEntity>().getPage(params),
                wrapper
        );

        PageUtils pageUtils = new PageUtils(page);

        pageUtils.setTotalCount(pageUtils.getList().size());
        return pageUtils;
    }

}