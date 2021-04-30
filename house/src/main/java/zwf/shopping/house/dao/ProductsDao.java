package zwf.shopping.house.dao;

import zwf.shopping.house.entity.ProductsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ProductsDao extends BaseMapper<ProductsEntity> {
	
}
