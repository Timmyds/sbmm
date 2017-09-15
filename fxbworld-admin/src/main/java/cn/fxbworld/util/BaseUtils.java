package cn.fxbworld.util;

public class BaseUtils {
	/**
	 * 根据驼峰命名，首字母大写
	 * @param tabName 原名
	 * @return 返回生成后的名字
	 *  例如：user_info 返回 UserInfo
	 */
	public static String getName(String tabName, String reChar) {
	   String[] arr = tabName.split(reChar);
	   String str = "";
	   for (int i = 0; i < arr.length; i++ ) {
	      String startChar = arr[i].substring(0,1).toUpperCase();
	      String lastChar = arr[i].substring(1, arr[i].length());
	      String newStr = startChar + lastChar;
	      str += newStr;
	   }
	   return str;
	}
}
