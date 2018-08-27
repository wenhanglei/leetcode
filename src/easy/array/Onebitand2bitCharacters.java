package easy.array;

/**
 * We have two special characters. The first character can be represented by one
 * bit 0. The second character can be represented by two bits (10 or 11).
 * 
 * Now given a string represented by several bits. Return whether the last
 * character must be a one-bit character or not. The given string will always
 * end with a zero.
 * 
 * @author wenhanglei
 */
public class Onebitand2bitCharacters {
	/*
	 * 思路：
	 */
	public boolean isOneBitCharacter(int[] bits) {
		return help(bits, 0);
	}
	
	private boolean help(int[] bits, int i){
		if(i >= bits.length) return false;
		else if(i == bits.length-1) return true;
		if(bits[i] == 0){
			return help(bits, i+1);
		}else{
			return help(bits, i+2);
		}
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		Onebitand2bitCharacters sol = new Onebitand2bitCharacters();
		boolean ret = sol.isOneBitCharacter(new int[]{1, 1, 0});
		System.out.println(ret);
	}
}
