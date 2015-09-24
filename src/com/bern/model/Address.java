package com.bern.model;

import java.io.Serializable;

/**
 * 地址信息基础类
 * @author Bern
 *
 */
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;	//人名
	private String mobile;	//电话
	private String address;		//住址
	
	public Address() {

	}
	
	public Address(String name, String mobile, String address) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
