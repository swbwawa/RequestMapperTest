package org.fkit.domain;
import java.io.Serializable;

//域对象，实现序列化接口
public class User implements Serializable{

	//私有字段
	private String loginname;
	private String password;
	private String username;
	
	//公共构造器
	public User() {
		super();
	}

	// set/get方法
	public String getloginname() {
		return loginname;
	}
	public void setloginname(String loginname) {
		this.loginname = loginname;
	}
	
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
}
