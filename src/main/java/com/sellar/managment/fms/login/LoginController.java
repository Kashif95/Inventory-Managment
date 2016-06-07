package com.sellar.managment.fms.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sellar.managment.fms.login.domain.LoginDetails;
import com.sellar.managment.fms.user.UserService;
import com.sellar.managment.fms.user.domain.UserDetails;


@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserService userService;
	
	 private static final Logger LOGGER = LogManager
	            .getLogger(LoginController.class);
	
	 @RequestMapping(value = "/authenticate", method = RequestMethod.PUT)
	    public @ResponseBody String login(@RequestBody LoginModel login,HttpServletRequest request) 
	 	{
		 UserDetails user = null;
		 try{
			 user = userService.getUserByUserId(login.getMobileNumber());
		 }catch(Exception e){
			 LOGGER.error("SQL EXCEPTION"+e);
		 }
		 
	        if(user!=null && user.getPassword().equals(login.getPassword())){
	        	
	        	String sessionId = loginService.getLoginDetailByMobileNumber(login.getMobileNumber()).getLoginId();
	        	if(sessionId==null){
	        		
	        		loginService.saveLoginDetails(user);
	        		sessionId = loginService.getLoginDetailByMobileNumber(login.getMobileNumber()).getLoginId();
	        	}
	        	
	        	request.getSession().setAttribute("sessionId", sessionId);
	        	request.getSession().setAttribute("userName", user.getUserFirstName());

	        	return "{\"status\":\"home\", \"msg\":\"" + user.getUserFirstName() + "\"}";
	        }
	        else{
	        	return "{\"status\":\"error\", \"msg\":\"" + "Invalid user" + "\"}";
	        }
	     }

	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public  String getLoginPage(ModelMap model, HttpServletRequest request,
	            HttpServletResponse response) 
	 	{
		 	return "redirect:resources/html/login.html";
	    }
	 
	 @RequestMapping(value = "/logout", method = RequestMethod.POST)
	    public  void logout(ModelMap model, HttpServletRequest request,
	            HttpServletResponse response) 
	 	{
				 HttpSession session = request.getSession(false);
				 if (request.isRequestedSessionIdValid() && session != null) {
				 session.invalidate();
				 }
		 handleLogOutResponse(request,response);
	    }
	 
	private void handleLogOutResponse(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			cookie.setMaxAge(0);
			cookie.setValue(null);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
	} 
	 
	

}
