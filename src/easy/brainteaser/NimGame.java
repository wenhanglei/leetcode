package easy.brainteaser;
/**
 * You are playing the following Nim Game with your friend: 
 * There is a heap of stones on the table, each time one of you 
 * take turns to remove 1 to 3 stones. The one who removes the 
 * last stone will be the winner. You will take the first turn 
 * to remove the stones.
 * @author wenhanglei
 */
public class NimGame {
	/*
	 * 思路：
	 * 当这堆石头的个数等于4的倍数的时候必输
	 */
	public boolean canWinNim(int n) {
		if(n % 4 == 0) return false;
		else return true;
    }
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
