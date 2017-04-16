package com.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.account.bean.CXUser;

@Controller
public class CXFUserController {
	
	@RequestMapping("/cxf/account.html")
	public String toAccount() {
		return "/new/account"; 
	}

	@RequestMapping("cxf/forget.html")
	public String toForget() {
		return "/new/forget"; 
	}
	
	
	@RequestMapping("cxf/account.json")
	@ResponseBody
	public String account(CXUser cx) {
		System.out.println(cx.getAccount());
		return "12345"; 
	}
}
