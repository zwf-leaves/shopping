package zwf.shopping.house.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import zwf.shopping.house.entity.TaskEntity;
import zwf.shopping.house.service.TaskService;
import zwf.shopping.house.utils.PageUtils;
import zwf.shopping.house.utils.R;



@RestController
@RequestMapping("house/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = taskService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		TaskEntity task = taskService.getById(id);

        return R.ok().put("task", task);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TaskEntity task){
        System.out.println(task.getName());
        System.out.println(task.getPhone());
        System.out.println(task.getSex());
        System.out.println(task.getDate());
        System.out.println(task.getAddress());
        System.out.println(task.getGoodsName());
		taskService.save(task);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TaskEntity task){
		taskService.updateById(task);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		taskService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
