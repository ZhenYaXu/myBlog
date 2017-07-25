package cn.xustars.myblog.controller;

import cn.xustars.myblog.utils.R;
import cn.xustars.myblog.utils.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by user on 2017/7/15.
 */
@Controller
public class LoginController {


    /**
     * 登录
     */
    @RequestMapping(value = "/blogger/login",method = RequestMethod.POST)
    @ResponseBody
    public R login(String username,String password) {

        System.out.println("+++++" + "lalalla");
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        }catch (AuthenticationException e){
            return R.error("用户验证失败");
        }

        return R.ok();
    }


    /**
     * 退出
     */
    @RequestMapping("/logout")
    public String logout() {
        System.out.println("+++++" + 2345436);
        ShiroUtils.logout();
        return "redirect:login.html";
    }
}
