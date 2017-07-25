package cn.xustars.myblog.controller;

import cn.xustars.myblog.entity.BlogType;
import cn.xustars.myblog.service.BlogTypeService;
import cn.xustars.myblog.utils.PageUtils;
import cn.xustars.myblog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2017/7/17.
 */
@Controller
@RequestMapping("blog/type")
public class BlogTypeController {

    @Autowired
    private BlogTypeService blogTypeService;

    @RequestMapping("/showList")
    public String showList(){
        return "blog/typeList.html";
    }

    @RequestMapping("/list")
    @ResponseBody
    public R queryList(int page, int limit){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("page",(page-1)*10);
        map.put("limit",limit);

        List<BlogType> typeList = blogTypeService.queryList(map);
        Integer total = blogTypeService.queryTotal();

        PageUtils pageUtil = new PageUtils(typeList,total,limit,page);
        return R.ok().put("page",pageUtil);
    }

    @RequestMapping("/save")
    @ResponseBody
    public R save(BlogType blogType){
        blogTypeService.save(blogType);
        return R.ok();
    }

    @RequestMapping("/update")
    @ResponseBody
    public R update(BlogType blogType){
        blogTypeService.update(blogType);
        return R.ok();
    }

    @RequestMapping("/deleteBatch")
    @ResponseBody
    public R deleteBatch(List<Integer> typeIds){
        blogTypeService.deleteBatch(typeIds);
        return R.ok();
    }
}
