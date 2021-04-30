package zwf.shopping.house.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zwf.shopping.house.entity.CatagoryEntity;
import zwf.shopping.house.service.CatagoryService;
import zwf.shopping.house.utils.PageUtils;
import zwf.shopping.house.utils.R;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("house/catagory")
public class CatagoryController {
    @Autowired
    private CatagoryService catagoryService;

    /**
     * 树形列表
     */
    @RequestMapping("/list/tree")
    public R list(){
        List<CatagoryEntity> catagoryEntities = catagoryService.list();
        List<CatagoryEntity> entityList = catagoryEntities.stream().filter(catagoryEntity -> {
            return catagoryEntity.getCatPid() == 0;
        }).map(entity->{
            entity.setChildren(getChildrens(entity,catagoryEntities));
            return entity;
        }).collect(Collectors.toList());

        return R.ok().put("message", entityList);
    }
    //递归所有菜单的子菜单
    private List<CatagoryEntity> getChildrens(CatagoryEntity root, List<CatagoryEntity> all){
        List<CatagoryEntity> children = all.stream().filter(catagoryEntity -> {
            return catagoryEntity.getCatPid() == root.getCatId();
        }).map(categoryEntity -> {
            //找子菜单
            categoryEntity.setChildren(getChildrens(categoryEntity,all));
            return categoryEntity;
        }).collect(Collectors.toList());
        return children;
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = catagoryService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    public R info(@PathVariable("catId") Integer catId){
		CatagoryEntity catagory = catagoryService.getById(catId);

        return R.ok().put("catagory", catagory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CatagoryEntity catagory){
		catagoryService.save(catagory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CatagoryEntity catagory){
		catagoryService.updateById(catagory);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] catIds){
		catagoryService.removeByIds(Arrays.asList(catIds));

        return R.ok();
    }

}
