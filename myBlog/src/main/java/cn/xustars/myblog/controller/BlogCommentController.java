package cn.xustars.myblog.controller;

import cn.xustars.myblog.entity.BlogComment;
import cn.xustars.myblog.service.BlogCommentService;
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
@RequestMapping("blog/comment")
public class BlogCommentController {

    @Autowired
    private BlogCommentService blogCommentService;

    @RequestMapping("/showList")
    public String showList(){
        return "blog/commentList.html";
    }

    @RequestMapping("/list")
    @ResponseBody
    public R queryList(int page, int limit){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("page",(page-1)*10);
        map.put("limit",limit);

        List<BlogComment> commentList = blogCommentService.queryList(map);
        Integer total = blogCommentService.queryTotal();

        PageUtils pageUtil = new PageUtils(commentList,total,limit,page);
        return R.ok().put("page",pageUtil);
    }

    @RequestMapping("/review")
    @ResponseBody
    public R reviewComment(int comId){
        blogCommentService.reviewComment(comId);
        return R.ok();
    }
}
