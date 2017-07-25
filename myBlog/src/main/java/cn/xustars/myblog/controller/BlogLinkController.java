package cn.xustars.myblog.controller;

import cn.xustars.myblog.entity.BlogLink;
import cn.xustars.myblog.service.BlogLinkService;
import cn.xustars.myblog.utils.PageUtils;
import cn.xustars.myblog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**博客评论
 * Created by user on 2017/7/17.
 */
@Controller
@RequestMapping("blog/link")
public class BlogLinkController {

    @Autowired
    private BlogLinkService blogLinkService;

    @RequestMapping("/showList")
    public String showList(){
        return "blog/linkList.html";
    }

    @RequestMapping("/list")
    @ResponseBody
    public R queryList(int page, int limit){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("page",(page-1)*10);
        map.put("limit",limit);

        List<BlogLink> linkList = blogLinkService.queryList(map);
        Integer total = blogLinkService.queryTotal();

        PageUtils pageUtil = new PageUtils(linkList,total,limit,page);
        return R.ok().put("page",pageUtil);
    }

    @RequestMapping("/save")
    @ResponseBody
    public R save(BlogLink blogLink){
        blogLinkService.save(blogLink);
        return R.ok();
    }

    @RequestMapping("/update")
    @ResponseBody
    public R update(BlogLink blogLink){
        blogLinkService.update(blogLink);
        return R.ok();
    }
}
