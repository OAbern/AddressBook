package com.bern.model;

/**
 * 常量类
 * <p>全局的常量应该在这里定义
 * @author Bern
 *
 */
public class ConstantValue {
	/**
	 * 退出命令的操作码
	 */
	public static final int QUIT_CODE = 0;
	
	/**
	 * 添加命令的操作码
	 */
	public static final int ADD_CODE = 2;
	
	/**
	 * 查找命令的操作码
	 */
	public static final int SEARCH_CODE = 3;
	
	/**
	 * 移除命令的操作码
	 */
	public static final int REMOVE_CODE = 4;
	
	/**
	 * 帮助命令的操作码
	 */
	public static final int HELP_CODE = 5;
	
	/**
	 * 退出命令的操作码
	 */
	public static final int UNKNOWN_CODE = -1;
	
	/**
	 * xml中根节点的名字
	 */
	public static final String XML_ROOT_NAME = "addressBook";
	
	/**
	 * xml中一个地址信息节点的名字
	 */
	public static final String XML_NODE_NAME = "entry";
	
	/**
	 * 字段人名
	 */
	public static final String F_NAME = "name";
	
	/**
	 * 字段电话
	 */
	public static final String F_MOBILE = "mobile";
	
	/**
	 * 字段地址
	 */
	public static final String F_ADDRESS = "address";
	
	/**
	 * 字段的数组
	 */
	public static final String[] FIELDS = {"name", "mobile", "address"};
	
	/**
	 * 存储信息的xml文件位置
	 */
	public static final String XML_PATH1 = "resources\\AddressBook.xml";
	
	/**
	 * 存储信息的xml文件位置
	 */
	public static final String XML_PATH2 = "AddressBook.xml";
	
	/**
	 * 分隔符
	 */
	public static final String SEPARATOR = "*";
	
	/**
	 * 匹配所有字符的正则表达式
	 */
	public static final String REGEX = "[\\s\\S]*";
	
	/**
	 * xml文件的基础内容
	 */
	public static final String XML_BASE_TEXT = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><addressBook></addressBook>";
}
