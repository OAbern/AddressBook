package com.bern.controller;

import java.util.List;

import com.bern.dao.AddressDao;
import com.bern.model.Address;
import com.bern.model.ConstantValue;
import com.bern.utils.InputUtil;

/**
 * 处理地址相关操作的控制器
 * @author Bern
 *
 */
public class AddressController {
	private AddressDao addressDao = new AddressDao();
	
	/**
	 * 添加一个地址信息
	 * @param address
	 */
	public boolean add() {
		Address address = new Address();
		int size = ConstantValue.FIELDS.length;
		String[] values = new String[size];
		
		for(int i=0; i<size; i++) {
			values[i] = InputUtil.getInputNotNull(ConstantValue.FIELDS[i]);
		}
		
		address.setName(values[0]);
		address.setMobile(values[1]);
		address.setAddress(values[2]);
		
		//调用持久化
		boolean result = addressDao.add(address);
		if(result) {
			System.out.println("address entry added");
		}else {
			System.out.println("address entry added faied");
		}
		return result;
	}
	
	/**
	 * 删除一个地址信息
	 * @param address
	 */
	public boolean remove() {
		String field = getRightField();
		String value = InputUtil.getInputNotNull(field);
		
		int result = addressDao.remove(field, value);	//持久化操作
		
		System.out.println(result+" address entries deleted");	
		
		if(result > 0) {
			return true;
		}else {
			return false;	
		}
	}
	
	/**
	 * 查找地址信息
	 * @param field
	 * @param value
	 * @return
	 */
	public boolean search() {
		System.out.println("You can use the wildcard \"*\"!");
		String field = getRightField();
		String value = InputUtil.getInputNotNull(field);
		
		List<Address> list = addressDao.search(field, value);
		if(list.size() == 0) {
			System.out.println("No elements matched!");
			return false;
		}else {
			System.out.println("Matched elements:");
			for(Address address : list) {
				System.out.println("name:"+address.getName());
				System.out.println("mobile:"+address.getMobile());
				System.out.println("address:"+address.getAddress());
				System.out.println("***********************");
			}
			return true;
		}
		
	}
	
	/**
	 * 获取正确的字段名字
	 * @return
	 */
	private String getRightField() {
		String field = InputUtil.getInputNotNull("by (name|mobile|address)");
		while(true) {
			for(String s : ConstantValue.FIELDS) {
				if(s.equals(field)) {
					return field;
				}
			}
			System.out.println("please input the right field!");
			field = InputUtil.getInputNotNull("by (name|mobile|address)");
		}
	}
	
}
