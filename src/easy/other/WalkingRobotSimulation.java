package easy.other;

/**
 * A robot on an infinite grid starts at point (0, 0) and faces north. The robot
 * can receive one of three possible types of commands:
 * 
 * @author wenhanglei
 */
public class WalkingRobotSimulation {
	/*
	 * 思路：
	 */
	public int robotSim(int[] commands, int[][] obstacles) {
		int toward = 0;              //机器人的移动方向，0向上，1向右，2向下，3向左
		int[] pos = {0, 0};
		for(int i = 0; i < commands.length; i++){
			if(commands[i] == -1) toward = (toward+1)%4;
			else if(commands[i] == -2) toward = (toward+3)%4;
			else{
				int preX = pos[0], preY = pos[1];
				if(toward == 0) pos[1] += commands[i];
				else if(toward == 1) pos[0] += commands[i];
				else if(toward == 2) pos[1] -= commands[i];
				else if(toward == 3) pos[0] -= commands[i];
				
				for(int[] obstacle : obstacles){
					
				}
			}
		}
		
	}
	
	private void move(int[] position, command, ){
		
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		WalkingRobotSimulation sol = new WalkingRobotSimulation();
		int[] commands = {4,-1,4,-2,4};
		int[][] obstacles = {{2,4}};
		int ret = sol.robotSim(commands, obstacles);
		System.out.println(ret);
	}
}
