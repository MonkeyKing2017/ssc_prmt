package asdad;

import com.account.bean.User;

public class Test2 {
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
