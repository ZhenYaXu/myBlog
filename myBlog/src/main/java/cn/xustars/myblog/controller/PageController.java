package cn.xustars.myblog.controller;

import cn.xustars.myblog.entity.BlogArticle;
import cn.xustars.myblog.service.BlogArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {

	@Autowired
	private BlogArticleService blogArticleService;

	@RequestMapping("sys/{url}.html")
	public String page(@PathVariable("url") String url){
		return "sys/" + url + ".html";
	}


	@RequestMapping("portal/showIndex")
	public String showIndex(){
		return "index.html";
	}

	@RequestMapping("portal/showAbout")
	public String showAbout(){
		return "about.html";
	}

	@RequestMapping("portal/showContact")
	public String showContact(){
		return "contact.html";
	}

	@RequestMapping("portal/showPost")
	public String showPost(){
		return "post.html";
	}

	/**
	 * 传递blogId
	 * @param blogId
	 * @return
     */
	@RequestMapping("portal/showDetailByBlogId")
	public String showPostById(Integer blogId, Model model){
		BlogArticle blogArticle = blogArticleService.queryById(blogId);
		model.addAttribute("blogArticle",blogArticle);
		return "post.html";
	}

}
