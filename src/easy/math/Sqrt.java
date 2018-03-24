package easy.math;
/**
 * Compute and return the square root of x.
 * @author wenhanglei
 */
public class Sqrt {
	/*
	 * 思路：
	 * 二分查找
	 * i*i <= x && (i+1)*(i+1) >= x
	 */
	public int mySqrt(int x) {
		//边界检查
		if(x == 0 || x == 1) return x;
		int begin = 0, end = x;
		while(begin <= end){
			int mid = begin + (end - begin)/2;
			if(mid <= x/mid && (mid+1)>x/(mid+1))
				return mid;
			else if(mid > x/mid)
				end = mid;
			else
				begin = mid + 1;
		}
		return -1;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		Sqrt sol = new Sqrt();
//		int res = sol.mySqrt(3);
//		System.out.println(res);
		for(int i = 0; i < 20; i++){
			int res = sol.mySqrt(i);
			System.out.println("sqrt(" + i + ")= " + res);
		}
	}
}
