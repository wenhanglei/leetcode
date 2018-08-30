package easy.math;

import java.util.LinkedList;
import java.util.List;

/**
 * A self-dividing number is a number that is divisible by every digit it
 * contains.
 * 
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 ==
 * 0, and 128 % 8 == 0.
 * 
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * 
 * Given a lower and upper number bound, output a list of every possible self
 * dividing number, including the bounds if possible.
 * 
 * @author wenhanglei
 */
public class SelfDividingNumbers {
	/*
	 * 思路：
	 */
	public List<Integer> selfDividingNumbers(int left, int right) {
		//边界检查
		List<Integer>  list = new LinkedList<>();
		if(right < left) return list;
		for(int i = left; i <= right; i++){
			if(isValid(i)) list.add(i);
		}
		return list;
	}
	
	private boolean isValid(int num){
		int r = num%10;
		int l = num/10;
		while(l != 0){
			if(r == 0) return false;
			if(num%r != 0) return false;
			r = l%10;
			l = l/10;
		}
		if(r == 0) return false;
		return num%r == 0;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		SelfDividingNumbers sol = new SelfDividingNumbers();
		List<Integer> ret = sol.selfDividingNumbers(1, 22);
		System.out.println(ret);
	}
}
