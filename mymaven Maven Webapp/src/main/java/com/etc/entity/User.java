package com.etc.entity;

import java.util.Date;

/** 用户信息实体类 */
public class User {
	private Integer user_id; // id
	private String user_phone;// 用户电话
	private String user_name; // 用户名称
	private String user_password; // 用户密码
	private Integer user_sex; // 性别
	private String user_picture; //头像图片
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public Integer getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(Integer user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_picture() {
		return user_picture;
	}
	public void setUser_picture(String user_picture) {
		this.user_picture = user_picture;
	}
	public User(Integer user_id, String user_phone, String user_name, String user_password, Integer user_sex,
			String user_picture) {
		super();
		this.user_id = user_id;
		this.user_phone = user_phone;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_sex = user_sex;
		this.user_picture = user_picture;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_phone=" + user_phone + ", user_name=" + user_name
				+ ", user_password=" + user_password + ", user_sex=" + user_sex + ", user_picture=" + user_picture
				+ "]";
	}
	

}
