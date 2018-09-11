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


//Controllerע������ָʾ������һ��������������ͬʱ����������
@Controller
//RequestMapping��������ע��һ���������࣬��ʱ�����з�������ӳ��Ϊ������༶�������
//��ʾ�ÿ�����������������󶼱�ӳ�䵽value������ָʾ��·����
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
		System.out.println("register Get����������");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/content/registerForm.jsp");
		return mv;
	}
	
	@PostMapping(value="/register")
	public ModelAndView register(
		@RequestParam("loginname") String loginname,
		@RequestParam("password")  String password,
		@RequestParam("username")  String username) {
		System.out.println("register Post����������");
		System.out.println("ע������"+loginname+"���룺"+password);
		User user = new User();
		user.setloginname(loginname);
		user.setpassword(password);
		user.setusername(username);
		userList.add(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/content/loginForm.jsp");
		return mv;
		//��ת����½ҳ��
		
	}
	
	@RequestMapping(value="/login")
	public ModelAndView login(
		@RequestParam(value="loginname",required=false) String loginname,
		@RequestParam(value="password",required=false) String password,Model model){
			System.out.println("��¼����"+loginname+"���룺"+password);
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

