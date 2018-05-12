package easy.binary_search;
/**
 * Suppose you have n versions [1, 2, ..., n] 
 * and you want to find out the first bad one, which 
 * causes all the following ones to be bad.
 * @author wenhanglei
 */
public class FirstBadVersion extends VersionControl {
	/*
	 * 思路：
	 */
	public int firstBadVersion(int n) {
		int lo = 1, hi = n;
		while(lo <= hi){
			int mid = lo + (hi-lo)/2;
			if(isBadVersion(mid)){
				hi = mid-1;
			}else{
				lo = mid+1;
			}
		}
        return lo;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		FirstBadVersion sol = new FirstBadVersion();
		int ret = sol.firstBadVersion(5);
		System.out.println(ret);
	}
}
