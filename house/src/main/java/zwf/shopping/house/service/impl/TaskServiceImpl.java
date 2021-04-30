package zwf.shopping.house.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import org.springframework.util.StringUtils;
import zwf.shopping.house.dao.TaskDao;
import zwf.shopping.house.entity.TaskEntity;
import zwf.shopping.house.service.TaskService;
import zwf.shopping.house.utils.PageUtils;
import zwf.shopping.house.utils.Query;


@Service("taskService")
public class TaskServiceImpl extends ServiceImpl<TaskDao, TaskEntity> implements TaskService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<TaskEntity> wrapper = new QueryWrapper<>();
        String nickName = (String)params.get("nickName");
        if(!StringUtils.isEmpty(nickName)){
            wrapper.eq("nick_name",nickName);
        }
        IPage<TaskEntity> page = this.page(
                new Query<TaskEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

}