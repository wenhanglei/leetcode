package easy.bit_manipulation;

import java.util.HashSet;

/**
 * Given two integers L and R, find the count of numbers in the range [L, R]
 * (inclusive) having a prime number of set bits in their binary representation.
 * 
 * (Recall that the number of set bits an integer has is the number of 1s
 * present when written in binary. For example, 21 written in binary is 10101
 * which has 3 set bits. Also, 1 is not a prime.)
 * 
 * @author wenhanglei
 */
public class PrimeNumberSetBitsBinaryRepresentation {
	/*
	 * 思路：使用set集合保存质数集合
	 */
	public int countPrimeSetBits(int L, int R) {
		//边界检查
		if(L > R) return 0;
		int cnt = 0;
		HashSet<Integer> primes = new HashSet<>();
		for(int i = L; i <= R; i++){
			cnt += isPrime(countSetBits(i), primes)?1:0;
		}
		return cnt;
	}
	
	private int countSetBits(int num){
		return Integer.bitCount(num);
	}
	
	private boolean isPrime(int num, HashSet<Integer> primes){
		if(num <= 1) return false;
		if(primes.contains(num)) return true;
		boolean[] marked = new boolean[num+1];
		for(int i = 2; i < marked.length; i++){
			if(!marked[i]){
				primes.add(i);
				for(int j = 2; j*i <= num; j++){
					if(!marked[i*j]) marked[i*j] = true;
				}
			}
		}
		return primes.contains(num);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		PrimeNumberSetBitsBinaryRepresentation sol = new PrimeNumberSetBitsBinaryRepresentation();
		int ret = sol.countPrimeSetBits(10, 15);
		System.out.println(ret);
	}
}
