package com.account.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.account.bean.CXUser;
import com.account.service.ICXService;

@Controller
@RequestMapping("/cxuser")
public class UserInfoController {
	@Autowired
	private ICXService cxService;
	
	@RequestMapping("/shouye")
	public ModelAndView shouye(
			@RequestParam("name") String name,
			@RequestParam("password") String password
			){
		ModelAndView mv = new ModelAndView("/shouye1");
		System.out.println(name+"::::"+password);
		return mv;
	}
	
	@RequestMapping("/shouye1")
	public ModelAndView shouye1(
			){
		ModelAndView mv = new ModelAndView("/index");
		return mv;
	}
	
	@RequestMapping("/geren1")
	public ModelAndView geren1(){
		ModelAndView mv = new ModelAndView("/geren2");
		return mv;
	}
	
	@RequestMapping("/geren2")
	public ModelAndView geren2(){
		ModelAndView mv = new ModelAndView("/geren3");
		return mv;
	}
	
	@RequestMapping("/geren3")
	public ModelAndView geren3(){
		ModelAndView mv = new ModelAndView("/renzheng1");
		return mv;
	}
	
	@RequestMapping("/renzheng1")
	public ModelAndView renzheng1(){
		ModelAndView mv = new ModelAndView("/renzheng2");
		return mv;
	}

	@RequestMapping("/renzheng2")
	public ModelAndView renzheng2(){
		ModelAndView mv = new ModelAndView("/index");
		return mv;
	}

	@RequestMapping("/wangjimima")
	public ModelAndView wangjimima(){
		ModelAndView mv = new ModelAndView("/wangjimima1");
		return mv;
	}
	
	@RequestMapping("/wangjimima1")
	public ModelAndView wangjimima1(
			HttpSession session,
			@RequestParam("account") String account 
			){
		ModelAndView mv = new ModelAndView();
		CXUser cx = new CXUser();
		cx.setAccount(account);
		System.out.println("忘记密码1：：："+account);
		// 你这个忘记密码 为何要调用一次注册？我用注册干嘛0.0我咋知道？...肯定是复制应该
		//..w yeshi yilianmengbi ..
		cx = cxService.findCXByAccount(account);
		if(cx == null){
			mv.setViewName("/error");
		}else{
			session.setAttribute("session" ,cx.getId());
			mv.setViewName("/wangjimima2");
		}
		return mv;
	}

	@RequestMapping("/wangjimima3")
	public ModelAndView wangjimima3(
			HttpSession session,
			@RequestParam("password") String password
			){
		ModelAndView mv = new ModelAndView();
		Long id = (Long) session.getAttribute("session");
		CXUser cxuser = new CXUser();
		cxuser.setId(id);
		cxuser.setPassword(password);
		if (cxService.updatePassword(cxuser) > 0) {
			mv.setViewName("/wangjimima4");
		}else {
			mv.setViewName("/error");
		}
		return mv;
	}
	
	@RequestMapping("/wangjimima2")
	public ModelAndView wangjimima2(){
		ModelAndView mv = new ModelAndView("/wangjimima3");
		return mv;
	}

	

	@RequestMapping("/wangjimima4")
	public ModelAndView wangjimima4(){
		ModelAndView mv = new ModelAndView("/index");
		return mv;
	}

	@RequestMapping("/zhuce")
	public ModelAndView zhuce(){
		ModelAndView mv = new ModelAndView("/zhuce1");
		return mv;
	}
	
	@RequestMapping("/zhuce1")
	public ModelAndView zhuce1(
			@RequestParam(value="account", required = false) String account,
			@RequestParam(value="password", required = false) String password
			){
		ModelAndView mv = new ModelAndView();
		CXUser cx = new CXUser();
		cx.setAccount(account);
		cx.setPassword(password);
		System.out.println(account+":::"+password);
		if (cxService.register(cx)) {
			mv.setViewName("/zhuce2");
		}else {
			mv.setViewName("/error");
		}
		return mv; 
	}
	
	
	
	@RequestMapping("/zhuce2")
	public ModelAndView zhuce2() {
		ModelAndView mv = new ModelAndView("/geren");
		return mv;
	}	
}