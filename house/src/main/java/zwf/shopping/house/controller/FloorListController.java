package zwf.shopping.house.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import zwf.shopping.house.entity.FloorListEntity;
import zwf.shopping.house.service.FloorListService;
import zwf.shopping.house.utils.PageUtils;
import zwf.shopping.house.utils.R;



@RestController
@RequestMapping("house/floorlist")
public class FloorListController {
    @Autowired
    private FloorListService floorListService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = floorListService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{lilstId}")
    public R info(@PathVariable("lilstId") Integer lilstId){
		FloorListEntity floorList = floorListService.getById(lilstId);

        return R.ok().put("floorList", floorList);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FloorListEntity floorList){
		floorListService.save(floorList);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FloorListEntity floorList){
		floorListService.updateById(floorList);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("house:floorlist:delete")
    public R delete(@RequestBody Integer[] lilstIds){
		floorListService.removeByIds(Arrays.asList(lilstIds));

        return R.ok();
    }

}
