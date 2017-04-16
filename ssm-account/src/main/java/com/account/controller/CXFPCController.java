package com.account.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.account.bean.CXUser;
import com.account.bean.Department;
import com.account.bean.Enterprise;
import com.account.bean.Job;
import com.account.bean.Person;
import com.account.service.ICXService;


@Controller
public class CXFPCController {
	@Autowired
	private ICXService cxService;
	
	@RequestMapping("/cxfpc/account.html")
	public String toAccount() {
		return "/cxfpc/account"; 
	}
	
	@RequestMapping("/cxfpc/hehehe.json")
	@ResponseBody
	public Job hehehe(@RequestBody Job job){
		System.out.println("wo?");
		List<Person> persons = job.getPersons();
		for (Person person : persons) {
			System.out.println(person);
		}
		return job;
	}
	@RequestMapping("/cxfpc/jsonList.json")
	@ResponseBody
	public Enterprise jsonList(){
		Enterprise e = new Enterprise();
		List<Department> ds = new ArrayList<Department>();
		Department d1 = new Department();
		Department d2 = new Department();
		Department d3 = new Department();
		List<Job> jobs1 = new ArrayList<Job>();
		List<Job> jobs2 = new ArrayList<Job>();
		List<Job> jobs3 = new ArrayList<Job>();
		Job j1 = new Job();
		Job j2 = new Job();
		Job j3 = new Job();
		Job j4 = new Job();
		Job j5 = new Job();
		List<Person> ps1 = new ArrayList<Person>();
		List<Person> ps2 = new ArrayList<Person>();
		List<Person> ps3 = new ArrayList<Person>();
		List<Person> ps4 = new ArrayList<Person>();
		List<Person> ps5 = new ArrayList<Person>();
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		Person p4 = new Person();
		Person p5 = new Person();
		Person p6 = new Person();
		Person p7 = new Person();
		e.setName("赛可电子商务有限公司");
		e.setDepartments(ds);
		d1.setName("部门1");
		d1.setJobs(jobs1);
		d2.setName("部门2");
		d2.setJobs(jobs2);
		d3.setName("部门3");
		d3.setJobs(jobs3);
		ds.add(d1);
		ds.add(d2);
		ds.add(d3);
		j1.setName("岗位1");
		j1.setPersons(ps1);
		j2.setName("岗位2");
		j2.setPersons(ps2);
		j3.setName("岗位3");
		j3.setPersons(ps3);
		j4.setName("岗位4");
		j4.setPersons(ps4);
		j5.setName("岗位5");
		j5.setPersons(ps5);
		jobs1.add(j1);
		jobs2.add(j2);
		jobs3.add(j3);
		jobs2.add(j4);
		jobs3.add(j5);
		p1.setName("员工1");
		p2.setName("员工2");
		p3.setName("员工3");
		p4.setName("员工4");
		p5.setName("员工5");
		p6.setName("员工6");
		p7.setName("员工7");
		ps1.add(p1);
		ps2.add(p2);
		ps3.add(p3);
		ps4.add(p4);
		ps5.add(p5);
		ps1.add(p6);
		ps2.add(p7);
		return e;
	}
	@RequestMapping("cxfpc/account.json")
	@ResponseBody
	public String account(String account,String password) {
		CXUser cx = new CXUser();
		cx.setAccount(account);
		cx.setPassword(password);
		System.out.println(account);
		System.out.println(password);
		if (cxService.findCXByAccount(account) == null) {
			cxService.register(cx);
			return "AAAA"; 
		}else {
			return "BBBB"; 
		}
	}
	
	@RequestMapping("/cxfpc/forget.html")
	public String toForget() {
		return "/cxfpc/forget"; 
	}
	
	@RequestMapping("cxfpc/forget.json")
	@ResponseBody
	public String forget(String account) {
		CXUser cx = new CXUser();
		cx.setAccount(account);
		if (cxService.findCXByAccount(account) != null) {
			return "forget";
		} else {
			return "sssss";
		}
		 
	}
	
	@RequestMapping("cxfpc/forget1.json")
	@ResponseBody
	public String forget1(String password,String account) {
		CXUser cx = new CXUser();
		cx.setAccount(account);
		if (cxService.findCXByAccount(account) != null) {
			cx.setId(cxService.findCXByAccount(account).getId());
			cx.setPassword(password);
			cxService.updatePassword(cx);
			System.out.println(cx.toString());
			return "forget";
		} else {
			return "sssss";
		}
	}
	
	
	
	@RequestMapping("/cxfpc/index.html")
	public String toIndex() {
		return "/cxfpc/index"; 
	}
	
	@RequestMapping("cxfpc/index.json")
	@ResponseBody
	public String index(String account ,String password) {
		CXUser cx = new CXUser();
		cx.setAccount(account);
		cx.setPassword(password);
		System.out.println(cx.toString()+"11111111");
		System.out.println(cx.toString());
		if (cxService.findCXBySession(account, password) != null) {
			System.out.println(cx.toString());
			return "index";
		} else {
			return "账号密码不存在";
		}
	}
	
	@RequestMapping("/cxfpc/personal.html")
	public String toPersonal() {
		return "/cxfpc/personal"; 
	}
	
	@RequestMapping("cxfpc/personal.json")
	@ResponseBody
	public String personal(CXUser cx) {
		return "personal";
	}
}
