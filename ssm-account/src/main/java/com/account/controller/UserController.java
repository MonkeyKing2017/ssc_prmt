package com.account.controller;

import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.account.bean.User;
import com.account.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/demo.do")
	public ModelAndView demo() {
		ModelAndView mv = new ModelAndView("success");
		mv.addObject("demo","success");
		return mv;
	}
	@RequestMapping(value="/register.do",method=RequestMethod.POST)
	public ModelAndView register(
			@RequestParam("account") String account,
			@RequestParam("gender") String gender,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber
			) {
		ModelAndView mv = new ModelAndView();
		User user = new User();
		user.setAccount(account);
		user.setCreateTime(Calendar.getInstance().getTime());
		user.setEmail(email);
		user.setGender(gender);
		user.setName(name);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
		System.out.println(account);
		boolean result = userService.register(user);
		if(result){
			mv.setViewName("redirect:/user/list.do");
		}else{
			mv.setViewName("/jsp/error");
		}
		return mv;
	}
	
	@RequestMapping(value="/register.do",method=RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("/jsp/register");
		return mv;
	}
	@RequestMapping("/list.do")
	public ModelAndView list(
			@RequestParam(required=false) String account,
			@RequestParam(required=false) String name) {
		ModelAndView mv = new ModelAndView("/jsp/list");
		User user = new User();
		user.setAccount(account);
		user.setName(name);
		List<User> list = userService.findAllUserByName(user);
		for (User user2 : list) {
			System.out.println(user2.getId());
		}
		mv.addObject("messageList",list);
		return mv;
	}
//	@RequestMapping(value="/list.do",method=RequestMethod.GET)
//	public ModelAndView list() {
//		ModelAndView mv = new ModelAndView("/jsp/list");
//		return mv;
//	}
	@RequestMapping("/deleteUser.do")
	public ModelAndView deleteUser(@RequestParam("id") Long id) {
		ModelAndView mv = new ModelAndView();
		if(userService.deleteUserById(id)){
			mv.setViewName("redirect:/user/list.do");
		}else{
			mv.setViewName("/jsp/error");
		}
		return mv;
	}
	@RequestMapping("/findById")
	public ModelAndView findTest(Long id) {
		ModelAndView mv = new ModelAndView("/findTest");
		User u = userService.findUserById(id);
		mv.addObject("demo",u);
		return mv;
	}
}
