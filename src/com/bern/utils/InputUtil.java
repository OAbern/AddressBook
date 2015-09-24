package com.bern.utils;

import java.util.Scanner;

/**
 * 输入工具类
 * <p>封装输入相关操作
 * @author Bern
 *
 */
public class InputUtil {
	public static final Scanner SCAN = new Scanner(System.in);
	
	/**
	 * 获取输入值
	 * @return 输入值
	 */
	public static String getInput() {
		return SCAN.nextLine();
	}
	
	/**
	 * 获取非空输入值
	 * <p>会先打印出提示信息，再要求输入；如果未输入，则重复提示，直到输入！
	 * @param tips 提示信息
	 * @return 输入值
	 */
	public static String getInputNotNull(String tips) {
		System.out.print(tips+":");
		String result = SCAN.nextLine().trim();
		while("".equals(result)) {
			System.out.println("you must input a string not empty!");
			System.out.print(tips+":");
			result = SCAN.nextLine();
		}
		return result;
	}
	
}
