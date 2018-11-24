package medium.string;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * @author wenhanglei
 */
public class SimplifyPath {
	/*
	 * 思路：先分割字符串，再使用栈
	 */
	public String simplifyPath(String path) {
		//边界检查
		if(path == null) return null;
		String[] strs = path.split("/");
		Stack<String> stack = new Stack<>();
		for (String str : strs) {
			if(!str.isEmpty()){
				if(".".equals(str)) continue;
				else if("..".equals(str)){
					if(!stack.isEmpty()) stack.pop();
				}else stack.push(str);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (String str : stack) {
			sb.append("/"+str);
		}
		return sb.length()==0?"/":sb.toString();
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		String path = "/a//b////c/d//././/..";
		String path1 = "/a/../../b/../c//.//";
		String path2 = "/a/./b/../../c/";
		String path3 = "/home/";
		String path4 = "/";
		SimplifyPath sol = new SimplifyPath();
		String ret = sol.simplifyPath(path4);
		System.out.println(ret);
	}
}
