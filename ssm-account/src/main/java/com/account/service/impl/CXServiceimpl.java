package com.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.bean.CXUser;
import com.account.mapper.ICXMapper;
import com.account.service.ICXService;

@Service
public class CXServiceimpl implements ICXService {
	/**
	 * 刚才报错说 这个service不能自动注入。他自动注入的原理是什么呢？
	 * 其实就是我之前说的  ICXMapper 这个不是一个接口吗？恩 
	 * 你以前学了 spring依赖注入。就是给他实例化一个对象。
	 * 恩以前不是 用 的属性注入吗？然后会自动给他注入一个实现类。这个学过吧？
	 * 是构造注入？属性注入 不是有两种么一种set 是啊 对的  一种是 set 其实你卸了这个@Autowired
	 * 就等同于 不用写那个什么 set了0.0 因为以前 不是都是在xml里面 去各种配置bean吗？恩
	 * 其实他这个autowired 就是在程序启动的时候 自动 去找到所有的autowired 然后 给你匹配
	 * 没必要去xml配置。比如 你用 @Autowired 注解了ICXService 
	 * 他就会去找 @Service 有这个东西的实现类并且 实现了ICXService接口的 实现类
	 * 懂吧？恩  如果 你实现类 没有用  @Service 注解 他是找不到的。于是 没有任何匹配的时候就报错了
	 * 因为你这个接口实例化不了。恩。回到dao上面来  dao也没有实例化 为何就不报错？
	 * 因为 他用了代理。代理对象 执行了 。0.0.那代理对象 如何执行的呢？我之前说了  
	 * 他其实就是去读取了mapper.xml 这也是为何mapper。xml名称要和类名一样。恩。然后里面的
	 * namespace也要和mapper的一样。namespace是？知道了？恩。所以这个地方很不爽。几个地方必须要一样
	 * 于是后来估计就都用纯注解+provider的方式了。恩。因为不至于运行报错。用了provider 编译期就会报错
	 * 这个以后再谈。恩。这不就成功了？恩恩。
	 * 其实啊，他这个如果只是输入昵称加密码 还不算成功。这个时候 你顶多给他存放在session里面。他后面不是要
	 * 补全个人信息吗 ？比如zhanghao？要么就是你需求看错了 。绝对不是昵称。应该是账号名+密码是账号+密码+再次确认
	 * 再次确认 我们可以不做 先  那个是js上检验，虽然后台也要检验。
	 * 但是 你这个传参 你写的是 name + password 应是 account+password。懂吗？恩去改吧然后 dao里面要改
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	//这个地方不是有个自动注解吗？这个时候是交给spring去实例化它 alt+ /
	@Autowired
	private ICXMapper cxMapper;
	
	@Override
	public boolean register(CXUser cx) {
		return cxMapper.addUser(cx) > 0 ? true : false;
	}
	
	@Override
	public int updatePassword(CXUser cx){
		return cxMapper.updatePassword(cx);
	}
	
	@Override
	public CXUser findCXByAccount(String account) {
		return cxMapper.findCXByAccount(account);
	}
	
	@Override
	public CXUser findCXById(Long id) {
		return cxMapper.findCXById(id);
	}

	@Override
	public CXUser findCXBySession(String account ,String password) {
		return cxMapper.findCXBySession(account, password);
	}
}
