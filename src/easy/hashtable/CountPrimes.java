package easy.hashtable;
/**
 * Count the number of prime numbers less than a non-negative number, n.
 * @author wenhanglei
 */
public class CountPrimes {
	/*
	 * 思路：
	 * 使用辅助数组记录合法的结果最后计数
	 */
	public int countPrimes(int n) {
		boolean[] marked = new boolean[n+1];
		int count = 0;                          //结果变量
		for(int i = 2; i < n; i++){
			if(!marked[i]){
				count++;
				for(int j = 2; j*i <= n; j++){
					marked[j*i] = true;
				}
			}
		}
		return count;
    }
	
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		CountPrimes sol = new CountPrimes();
		int res = sol.countPrimes(2);
		System.out.println(res);
	}
}
