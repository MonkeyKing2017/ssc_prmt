package asdad;

public interface InterfaceTest {
	/**
	 * 0 . 0 =-= 我后来今天上午的时候 突然想起来 是不是 页面上的
	 * contextType 来指定的
	 * 然后就打算测试 和我同事打赌  然后 刚才 你听到了吧  我没开声音。。。
	 * 然后 发现啊  其实就是这个contextType来指定的  因为我想到
	 * Spring 不至于蠢成那么狠吧？... 所以 我就来 控制你电脑
	 * 把那些配置全删除 ，然后直接发请求 果然 还是成功。看来就是ajax请求 必须要写这个json
	 * 除非 你不是json入参。然后controller里面需要用到 RequestBoby注解。知道了没？》恩
	 * 0.0 这个是啥？那张图？恩不清楚  那个标签 你没有用过？  那个标签不是写在开头的么
	 * 见过  不记得了 就是jsp的导入的样子或者说 引用其他页面吧  好像是  你等下继续看面试题的时候 会碰到
	 * 碰到这种 tomcat 优化啊 看看就行。然后jsp的基本动作啊 了解一下知道 就行了 。
	 * 别特么一问就不知道了。你在看题 也在复习  知道吗？恩。恩 继续吧 我输别人一杯奶茶了。。。
	 * 
	 * 你在一个地方总结一下  就是ajax学习文档里面 写上 如果发送json请求 ，也就是请求参数是
	 * json的话  ajax必须包含 contextType:"application/json" 这个属性
	 * 以及 url 其他的 可以省略。
	 * 还有就是 controller 接收参数 必须要用 @RequestBody.
	 * 知道了 ? ??? =-=知道了 = = 继续看题
	 * @param xixi
	 */
	void invoke(String xixi);
}
