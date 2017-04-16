package asdad;

import com.account.bean.User;

public class Test2 {
	// 就写不出来回调吗？... 逻辑  思维  回调肯定是三个方法 一个是调用方  被调用方 然后 调用方的参数里面有个接口。
	// 也就是三个类 service  调用方逻辑  被调用方逻辑 一个类也可以。那就是 这个方法调用那个方法咩。
	/**
	 * 有哪里不懂的？   没有 那就好  其实 就是啥 而接口他要有作用 必须是啥？实现类咩。你说
	 * 必须实现。恩 所以啊  我们就是传递了一个接口而已  。以前我们不都是传递对象 对象的一切 都能访问
	 * 而现在 我只需定一个接口 你们传递一个实现类即可。或者 直接new 这个接口 其实 也就是匿名内部类
	 * 恩。那么别人问你接口能不能new
	 * 你咋回答？能。。。我都不确定。你百度一下。所以 不能被new
	 * 他这个只是匿名类而已。看着是new 其实并不是
	 * 因为new的定义是 会执行构造函数 而对于接口来说 则没有构造函数。
	 * 那new个锤子...这个匿名类 只是相当于他的一个实现类而已。不过是匿名的恩
	 * @param interfaceTest
	 */
	public void show(InterfaceTest interfaceTest){
		System.out.println("我操作执行完了。准备开始回调!!!");
		interfaceTest.invoke("苹果");// 这个是无参数，有参数 我们可以在这个方法传入我们要传入的参数
	}
	
	public static void main(String[] args) {
		User user1  =new User();// 从数据库获得
		Test2 test = new Test2();
		final String xd = "小刀";
		// 这个时候 假如需要重新 从数据库拿一个user 就这么个鸟样了 那就
		user1 = new User();
		user1.setName("我曹");//这步代表修改。那么我们能把User变成final？
		// 如何传递进去呢？
		final User user = user1;
		test.show(new InterfaceTest() {
			public void invoke(String xixi) {
				System.out.println("沃日，还特么执行了！");
				System.out.println("谢大爷赏赐的："+xixi);
				System.out.println("开心的拿出来了："+xd+":准备削皮！！！");
				System.out.println(user.getName());
			}
		});
	}
}
