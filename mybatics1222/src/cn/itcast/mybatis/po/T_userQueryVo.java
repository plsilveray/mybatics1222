package cn.itcast.mybatis.po;
/*
 * vo视图层面的对象，从页面一直穿过来的对象
 * po持久层的对象
 * pojo自定义的对象
 */
public class T_userQueryVo {
	//private String uid; 这样写在UserMapper.xml中的综合查询传值就不用在类后面加点，可以直接写uid
	//包装需要的查询条件
	private T_userCustom userCustom;

	public T_userCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(T_userCustom userCustom) {
		this.userCustom = userCustom;
	}
	
}
