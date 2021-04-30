package zwf.shopping.house.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import zwf.shopping.house.entity.CatitemsEntity;
import zwf.shopping.house.service.CatitemsService;
import zwf.shopping.house.utils.PageUtils;
import zwf.shopping.house.utils.R;


@RestController
@RequestMapping("house/catitems")
public class CatitemsController {
    @Autowired
    private CatitemsService catitemsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(){
        List<CatitemsEntity> list = catitemsService.list();
        return R.ok().put("message", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		CatitemsEntity catitems = catitemsService.getById(id);

        return R.ok().put("catitems", catitems);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CatitemsEntity catitems){
		catitemsService.save(catitems);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CatitemsEntity catitems){
		catitemsService.updateById(catitems);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		catitemsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
