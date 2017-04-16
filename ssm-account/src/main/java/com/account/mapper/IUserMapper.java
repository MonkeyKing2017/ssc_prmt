package com.account.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;
import static com.account.constants.TableConstants.*;
import com.account.bean.User;
import com.account.provider.UserProvider;

public interface IUserMapper {
	User findUserByNameAndPassword(String name,String password);
	
	User findUserByName(String name);
	@Insert("insert into user( account, NAME, CREATETIME, EMAIL, GENDER, PASSWORD, PHONENUMBER) "
			+ "values(#{account},#{name},#{createTime},#{email},#{gender},#{password},#{phoneNumber})")
	
	@Options(useGeneratedKeys= true,keyProperty="id")
	int addUser(User u);
	
	@SelectProvider(type=UserProvider.class,method="findAllUserByName")
	List<User> findAllUserByName(User user);
	
	
	
	/**
	 * 这是我昨天的方法  我有注解吗？ 你非要看到上面的注解？我让你参照昨天我写的功能 也就是这个功能  你特么
	 * 参照的啥？弄错=-=而且  为何 bean 里面 有个 user.xml？这不是我写的0.0
	 * 也就是说  最后  dao 这边其实上 是调用 mapper.xml里面的和这个方法名一样的方法 是不是？恩
	 * 它用的是啥技术？ 反射。知道吗？0.0 知道吗？没看到反射  我只是告诉你 。别人写在jar包里面了。
	 * 他就是用的反射。实现出来的动态代理。然后再去执行的。你知道就可以了。不用看到恩
	 * 因为平常 我们接口 必须有实现类才能执行  对不对？恩，他其实就是用反射
	 * 然后 实例化的时候 如果我们给他设置了 xml。那么系统会默认给他一个代理对象。然后 这个对象执行这个方法
	 * 就会去执行xml里面同名的方法 。知道吗？知道了以后有兴趣 可以 去学学动态代理。
	 * java里面有个类叫做代理类。0.0 你要做一些操作  没必要自己去执行 。有人代理然后你把东西给他 
	 * 他去帮你执行。所以实现了你这个方法
	 * 最后   其实就是调用IUserMapper.xml里面的 id为findUserById 的sql 知道吗？恩
	 * @param id
	 * @return
	 */
	User findUserById(Long id);
	
	@Delete("delete from "+ USER +" where id = #{id}")
	int deleteById(Long id);
}
