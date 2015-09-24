package com.bern.main;

import com.bern.controller.AddressController;
import com.bern.model.ConstantValue;
import com.bern.utils.InputUtil;

/**
 * 程序的主入口
 * @author Bern
 *
 */
public class Main {
	private static AddressController controller = new AddressController();
	
	public static void main(String[] args) {
		System.out.println("Welcome to AddressBook Application!");
		int code = 1;
		while(code != ConstantValue.QUIT_CODE) {
			//输入命令
			code = getCommandCode(InputUtil.getInput().trim());
			
			//根据命令，判断处理流程
			process(code);
		}
		
		System.out.println("Bye!");
		System.exit(0);
		
	}
	
	/**
	 * 根据输入的命令返回相应的操作码
	 * <p>命令正常返回大于0的数字，未知命令返回-1
	 * @return
	 */
	public static int getCommandCode(String command) {
		switch (command) {
		case "!quit":
			return ConstantValue.QUIT_CODE;
			
		case "add": 
			return ConstantValue.ADD_CODE;
			
		case "search":
			return ConstantValue.SEARCH_CODE;
			
		case "remove":
			return ConstantValue.REMOVE_CODE;
			
		case "!help":
			return ConstantValue.HELP_CODE;
			
		default:
			return ConstantValue.UNKNOWN_CODE;
		}
	}
	
	/**
	 * 根据相应的命令代码选择相应的处理流程
	 * @param code
	 * @return 返回操作结果
	 */
	public static boolean process(int code) {
		switch (code) {
		case ConstantValue.QUIT_CODE:		//退出
			return true;
			
		case ConstantValue.ADD_CODE:		//添加
			return controller.add();
			
		case ConstantValue.SEARCH_CODE:		//查找
			return controller.search();

		case ConstantValue.REMOVE_CODE:		//删除
			return controller.remove();
			
		case ConstantValue.HELP_CODE: {		//帮助
			System.out.println("add/rearch/remove/!help/!quit is acctpted");
			return true;
		}
			
		case ConstantValue.UNKNOWN_CODE: {		//未知的代码
			System.out.println("Invalid command! add/rearch/remove/!help/!quit is acctpted");
			return true;
		}
		
		default:
			break;
		}
		return false;
	}
}
