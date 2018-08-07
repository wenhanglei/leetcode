package easy.string;

/**
 * Initially, there is a Robot at position (0, 0). Given a sequence of its
 * moves, judge if this robot makes a circle, which means it moves back to the
 * original place.
 * 
 * The move sequence is represented by a string. And each move is represent by a
 * character. The valid robot moves are R (Right), L (Left), U (Up) and D
 * (down). The output should be true or false representing whether the robot
 * makes a circle.
 * 
 * @author wenhanglei
 */
public class JudgeRouteCircle {
	/*
	 * 思路：使用数组模拟移动
	 */
	public boolean judgeCircle(String moves) {
		int[] robot = {0, 0};
		char[] array = moves.toCharArray();
		for(char ch : array){
			switch (ch) {
			case 'U':
				robot[1] += 1;break;
			case 'D':
				robot[1] += -1;break;
			case 'L':
				robot[0] += -1;break;
			case 'R':
				robot[0] += 1;break;
			default:return false;
			}
		}
		return (robot[0] == 0 && robot[1] == 0);
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		JudgeRouteCircle sol = new JudgeRouteCircle();
		boolean ret = sol.judgeCircle("LL");
		System.out.println(ret);
	}
}
