package com.bern.utils;

import com.bern.model.ConstantValue;

/**
 * 校验工具类
 * @author Bern
 *
 */
public class ValidateUtils {
	
	/**
	 * 使用通配符匹配字符串
	 * @param v1 含有通配符的字符串
	 * @param v2 待匹配的字样
	 * @return 匹配结果
	 */
	public static boolean wildcardMatching(String v1, String v2) {
		if(v1==null || v2==null) {
			return false;
		}
		
		if(v1.contains(ConstantValue.SEPARATOR)) {		//判断是否包含通配符
			v1 = v1.replace(ConstantValue.SEPARATOR, ConstantValue.REGEX);		//替换通配符为正则表达式		
			return v2.matches(v1);
		}else {
			return v1.equals(v2);
		}
		
	}
}
