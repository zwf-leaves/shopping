package zwf.shopping.house.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zwf.shopping.house.entity.PicturesEntity;
import zwf.shopping.house.service.PicturesService;
import zwf.shopping.house.utils.PageUtils;
import zwf.shopping.house.utils.R;

import java.util.Arrays;
import java.util.Map;


@RestController
@RequestMapping("house/pictures")
public class PicturesController {
    @Autowired
    private PicturesService picturesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = picturesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{picsId}")
    public R info(@PathVariable("picsId") Integer picsId){
		PicturesEntity pictures = picturesService.getById(picsId);

        return R.ok().put("pictures", pictures);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PicturesEntity pictures){
		picturesService.save(pictures);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PicturesEntity pictures){
		picturesService.updateById(pictures);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] picsIds){
		picturesService.removeByIds(Arrays.asList(picsIds));

        return R.ok();
    }

}
