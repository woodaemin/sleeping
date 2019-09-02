package user.model;

import java.io.*;
import java.sql.Date;

public class UserVO implements Serializable {
	// 맴버변수 => property
	// html의 input name과 일치시켜주면 편리
	// db의 컬럼명과 일치시켜주면 편리
	private String name;
	private String userid;
	private String pwd;
	private String email;

	public UserVO() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserVO(String email, String name, String userid, String pwd) {
		super();
		this.email = email;
		this.name = name;
		this.userid = userid;
		this.pwd = pwd;

	}

}
