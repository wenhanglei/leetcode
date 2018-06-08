package easy.other;

import java.util.LinkedList;
import java.util.List;

/**
 * Write a program that outputs the string representation 
 * of numbers from 1 to n.
 * @author wenhanglei
 */
public class FizzBuzz {
	/*
	 * 思路：
	 * 
	 */
	public List<String> fizzBuzz(int n) {
		List<String> ret = new LinkedList<>();
		//边界判断
		if(n < 1) return ret;
		int a = 3;
		int b = 5;
		int c = 15;
		for(int i = 1; i <= n; i++){
			if(i==c){
				ret.add("FizzBuzz");
				c+=15;
				a+=3;
				b+=5;
			}
			else if(i==b){
				ret.add("Buzz");
				b+=5;
			}
			else if(i==a){
				ret.add("Fizz");
				a+=3;
			}else
				ret.add(""+i);
		}
        return ret;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		FizzBuzz sol = new FizzBuzz();
		List<String> ret = sol.fizzBuzz(15);
		System.out.println(ret);
	}
}
