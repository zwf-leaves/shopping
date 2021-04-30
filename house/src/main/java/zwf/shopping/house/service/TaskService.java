package zwf.shopping.house.service;

import com.baomidou.mybatisplus.extension.service.IService;
import zwf.shopping.house.entity.TaskEntity;
import zwf.shopping.house.utils.PageUtils;

import java.util.Map;


public interface TaskService extends IService<TaskEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

