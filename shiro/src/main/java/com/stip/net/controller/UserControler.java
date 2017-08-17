package com.stip.net.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.stip.net.entity.User;
import com.stip.net.realm.ShiroRealm;
import com.stip.net.service.UserService;
import com.stip.net.utils.CipherUtil;

@RestController
public class UserControler {
	private static Logger logger = LoggerFactory.getLogger(ShiroRealm.class);
	@Autowired
	private UserService userService;
	
	/**
	 * 根据Id获取用户信息
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/{id}/showUser")
	public String showUser(@PathVariable int id, HttpServletRequest request) {
		User user = userService.getUserById(id);
		System.out.println(user.getName());
		request.setAttribute("user", user);
		
		return "showUser";
	}
	
	/**
	 * 初始登陆界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login.do", method = { RequestMethod.POST,RequestMethod.GET})
	public ModelAndView tologin(HttpServletRequest request, HttpServletResponse response){
		logger.info("来自IP[" + request.getRemoteHost() + "]的访问");
		ModelAndView modelAndView = new ModelAndView("login");

		return modelAndView;
	}
	
	/**
	 * 验证用户名和密码
	 * @param request
	 * @return
	 */
	@RequestMapping("/checkLogin.do")
	public ModelAndView login(HttpServletRequest request) {
		// 取得用户名
		String username = request.getParameter("username");
		//取得 密码，并用MD5加密
		String password = CipherUtil.generatePassword(request.getParameter("password"));
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		
		Subject subject = SecurityUtils.getSubject();
		ModelAndView modelAndView =null;
		try {
			System.out.println("----------------------------");
			if (!subject.isAuthenticated()){//使用shiro来验证
				token.setRememberMe(true);
				subject.login(token);//验证角色和权限
			}
			modelAndView = new ModelAndView("index");
		} catch (Exception e) {
			logger.error(e.getMessage());
			modelAndView = new ModelAndView("login");
		}

		return modelAndView;
	}
  
    /**
     * 退出
     * @return
     */
    @RequestMapping(value = "/logout")  
    public String logout() {  
        Subject subject = SecurityUtils.getSubject();  
        String result = "logout";  
        subject.logout();
        
        return result;  
    }  
    
    /**
     * 检查用户登录是否有效
     * @return
     */
    @RequestMapping(value = "/chklogin", method = RequestMethod.POST)  
    public String chkLogin() {  
        Subject subject = SecurityUtils.getSubject();  
        if (!subject.isAuthenticated()) {  
            return "false";  
        }  
        return "true";  
    }  
    
    /**
     * 删除
     * @return
     */
    @RequestMapping(value = "/deleted", method = RequestMethod.GET)
    @RequiresPermissions("delete_button")
    public String deleted() {
    	System.out.println("删除成功");
        return "true";  
    } 
}
