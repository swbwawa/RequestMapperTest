package org.fkit.domain;
import java.io.Serializable;

//�����ʵ�����л��ӿ�
public class User implements Serializable{

	//˽���ֶ�
	private String loginname;
	private String password;
	private String username;
	
	//����������
	public User() {
		super();
	}

	// set/get����
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
