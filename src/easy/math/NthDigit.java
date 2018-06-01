package easy.math;
/**
 * Find the nth digit of the infinite integer sequence 
 * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * @author wenhanglei
 */
public class NthDigit {
	/*
	 * 思路：
	 * 1.要查的数字有多少位
	 * 2.要查的数字是多少
	 * 3.要查的是哪一位的数字
	 */
	public int findNthDigit(int n) {
		long i = 1;                    //要查的数字的位数
		long j = 1;
		long k = n;
		while(k/(9*j*i+1)!=0){
			k-=9*j*i;
			j*=10;
			i++;
		}
		long l = j + (k-1)/i;          //要查的是哪一个数
		long m = (k-1)%i;              //要查的是哪一位0开头
		for(long o = i-m-1; o > 0; o--){
			l/=10;
		}
		return (int) (l%10);
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		NthDigit sol = new NthDigit();
		int ret = sol.findNthDigit(2147483647);
		System.out.println(ret);
	}
}
