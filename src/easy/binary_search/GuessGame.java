package easy.binary_search;

public class GuessGame {

	public int guess(int num){
		int a = 6;
		if(num < a) return -1;
		else if(num > a) return 1;
		else return 0;
	}
	
}
