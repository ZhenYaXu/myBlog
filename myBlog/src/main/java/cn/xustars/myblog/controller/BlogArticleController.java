package cn.xustars.myblog.controller;

import cn.xustars.myblog.entity.BlogArticle;
import cn.xustars.myblog.service.BlogArticleService;
import cn.xustars.myblog.utils.PageUtils;
import cn.xustars.myblog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("blog/article")
public class BlogArticleController {

	@Autowired
	private BlogArticleService blogArticleService;

	/**
	 * 跳转到信息列表页面
	 * @return
	 */
	@RequestMapping("/showList")
	public String showList(){

		return "blog/blogList.html";
	}

    /**
     * 传递数据到编辑页面
     * @return
     */
    @RequestMapping("/transmitDataToUpdate")
    @ResponseBody
    public R transmitDataToUpdate(Integer blogId){

        BlogArticle blogArticle = blogArticleService.queryById(blogId);
        return R.ok().put("blogArticle",blogArticle);
    }

    /**
     * 跳转到blog编辑页面
     * @return
     */
    @RequestMapping("/showUpdate")
    public String showUpdate(){
        return "blog/updateBlog.html";
    }

	/**
	 * 查询所有博客
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public R queryList(Integer page, Integer limit){
		//分页准备
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);

		List<BlogArticle> articleList = blogArticleService.queryList(map);

		Integer total = blogArticleService.queryTotal();

		PageUtils pageUtil = new PageUtils(articleList,total,limit,page);
		return R.ok().put("page", pageUtil);
	}

    /**
     * 查询所有博客
     * @return
     */
    @RequestMapping("/pageList")
    @ResponseBody
    public R pageList(Integer page, Integer limit){
        //分页准备
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("offset", (page - 1) * limit);
        map.put("limit", limit);

        List<BlogArticle> articleList = blogArticleService.queryList(map);
        Integer total = blogArticleService.queryTotal();
        Integer totalPage;
        if(total % limit > 0){
            totalPage = (total / limit) + 1;
        }else{
            totalPage = (total / limit);
        }

        return R.ok().put("blogList",articleList).put("curPage",page).put("pageSize",limit).put("totalPage",totalPage);
    }


    /**
	 * 根据类型查找博客
	 * @param typeId
	 * @return
	 */
	@RequestMapping("/queryListByCondition")
	@ResponseBody
	public R queryListByCondition(Integer typeId){
		Map<String,Object> map = new HashMap<String,Object>();
		List<BlogArticle> articleListByType = blogArticleService.queryListByCondition(map);
		return R.ok().put("articleListByType", articleListByType);
	}

	/**
	 *
	 */
	@RequestMapping("/showAdd")
	public String showAdd(){
		return "blog/addblog.html";
	}

	/**
	 * 新增博客
	 * @param blogArticle
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public R add(@RequestBody BlogArticle blogArticle){
        System.out.println("+++++" + blogArticle.getContent());
        System.out.println("+++++" + blogArticle.getTitle());
		blogArticleService.add(blogArticle);
		return R.ok();
	}
	
	/**
	 * 更新博客
	 * @param blogArticle
	 * @return
	 */
	@RequestMapping("/update")
    @ResponseBody
	public R update(@RequestBody BlogArticle blogArticle){
		blogArticleService.updateById(blogArticle.getBlogId());
		return R.ok();
	}
	
	/**
	 * 批量删除博客 (将状态更改为 0 表示删除) 0:删除  1:正常 
	 * @param blogIds
	 * @return
	 */
	@RequestMapping("/deleteBatch")
	public R deleteBatch(List<Integer> blogIds){
		blogArticleService.deleteBatch(blogIds);
		return R.ok();
	}
	
}
