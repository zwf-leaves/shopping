package zwf.shopping.house.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import zwf.shopping.house.entity.FloorListEntity;
import zwf.shopping.house.entity.FloorTitleEntity;
import zwf.shopping.house.service.FloorListService;
import zwf.shopping.house.service.FloorTitleService;
import zwf.shopping.house.utils.PageUtils;
import zwf.shopping.house.utils.R;
import zwf.shopping.house.vo.FloorVo;


@RestController
@RequestMapping("house/floortitle")
public class FloorTitleController {
    @Autowired
    private FloorTitleService floorTitleService;

    @Autowired
    private FloorListService floorListService;

    /**
     * 获取展示首页楼层信息
     */
    @RequestMapping("/floordata")
    public R list(){
        List<FloorTitleEntity> titleEntities = floorTitleService.list();
        List<FloorVo> collect = titleEntities.stream().map(floorTitleEntity -> {
            FloorVo floorVo = new FloorVo();
            floorVo.setTitleEntity(floorTitleEntity);
            List<FloorListEntity> floorListEntities = floorListService.list(new QueryWrapper<FloorListEntity>().eq("title_id", floorTitleEntity.getTitleId()));
            floorVo.setListEntities(floorListEntities);
            return floorVo;
        }).collect(Collectors.toList());

        return R.ok().put("message", collect);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = floorTitleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{titleId}")
    public R info(@PathVariable("titleId") Integer titleId){
		FloorTitleEntity floorTitle = floorTitleService.getById(titleId);

        return R.ok().put("floorTitle", floorTitle);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FloorTitleEntity floorTitle){
		floorTitleService.save(floorTitle);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FloorTitleEntity floorTitle){
		floorTitleService.updateById(floorTitle);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] titleIds){
		floorTitleService.removeByIds(Arrays.asList(titleIds));

        return R.ok();
    }

}
