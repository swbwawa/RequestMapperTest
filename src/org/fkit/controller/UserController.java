package org.fkit.controller;

import java.util.ArrayList;
import java.util.List;
import org.fkit.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


//Controller注解用于指示该类是一个控制器，可以同时处理多个请求
@Controller
//RequestMapping可以用来注释一个控制器类，此时，所有方法都将映射为相对于类级别的请求
//表示该控制器处理的所有请求都被映射到value属性所指示的路径下
@RequestMapping(value="/user")
public class UserController {
	//
	private static List<User> userList;
	//
	public UserController() {
		super();
		userList =new ArrayList<User>();
	}
	@GetMapping(value="/register")
	public  ModelAndView registerForm() {
		System.out.println("register Get方法被调用");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/content/registerForm.jsp");
		return mv;
	}
	
	@PostMapping(value="/register")
	public ModelAndView register(
		@RequestParam("loginname") String loginname,
		@RequestParam("password")  String password,
		@RequestParam("username")  String username) {
		System.out.println("register Post方法被调用");
		System.out.println("注册名："+loginname+"密码："+password);
		User user = new User();
		user.setloginname(loginname);
		user.setpassword(password);
		user.setusername(username);
		userList.add(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/content/loginForm.jsp");
		return mv;
		//跳转到登陆页面
		
	}
	
	@RequestMapping(value="/login")
	public ModelAndView login(
		@RequestParam(value="loginname",required=false) String loginname,
		@RequestParam(value="password",required=false) String password,Model model){
			System.out.println("登录名："+loginname+"密码："+password);
			for(User user : userList) {
				if(user.getloginname().equals(loginname)
						&& user.getpassword().equals(password)) {
					System.out.println("!!!!");
					model.addAttribute("user",user);
					ModelAndView mv = new ModelAndView();
					mv.setViewName("/WEB-INF/content/welcome.jsp");
					return mv;
				}
			}
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/WEB-INF/content/loginForm.jsp");
			return mv;
		}
}

