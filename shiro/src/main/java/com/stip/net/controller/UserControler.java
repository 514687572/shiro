package com.stip.net.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stip.net.domain.User;
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
	public String tologin(HttpServletRequest request, HttpServletResponse response){
		logger.info("来自IP[" + request.getRemoteHost() + "]的访问");
		return "login";
	}
	
	/**
	 * 验证用户名和密码
	 * @param request
	 * @return
	 */
	@RequestMapping("/checkLogin.do")
	public String login(HttpServletRequest request) {
		String result = "login.do";
		// 取得用户名
		String username = request.getParameter("username");
		//取得 密码，并用MD5加密
		String password = CipherUtil.generatePassword(request.getParameter("password"));
		//String password = request.getParameter("password");
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		
		Subject currentUser = SecurityUtils.getSubject();
		try {
			System.out.println("----------------------------");
			if (!currentUser.isAuthenticated()){//使用shiro来验证
				token.setRememberMe(true);
				currentUser.login(token);//验证角色和权限
			}
			System.out.println("result: " + result);
			result = "index";//验证成功
		} catch (Exception e) {
			logger.error(e.getMessage());
			result = "login.do";//验证失败
		}
		return result;
	}
  
    /**
     * 退出
     * @return
     */
    @RequestMapping(value = "/logout")  
    public String logout() {  
        Subject currentUser = SecurityUtils.getSubject();  
        String result = "logout";  
        currentUser.logout();
        
        return result;  
    }  
    
    /**
     * 检查用户登录是否有效
     * @return
     */
    @RequestMapping(value = "/chklogin", method = RequestMethod.POST)  
    public String chkLogin() {  
        Subject currentUser = SecurityUtils.getSubject();  
        if (!currentUser.isAuthenticated()) {  
            return "false";  
        }  
        return "true";  
    }  
}
