package easy.other;

import java.util.HashSet;
import java.util.Set;

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
		Set<String> obst = new HashSet<>();
		for(int[] obstacle : obstacles){
			obst.add(obstacle[0] + " " + obstacle[1]);
		}
		int x = 0, y = 0, ret = 0;
		int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		for(int i = 0; i < commands.length; i++){
			if(commands[i] == -1) toward = (toward+1)%4;
			else if(commands[i] == -2) toward = (toward+3)%4;
			else{
				while(commands[i]-- > 0){
					if(!obst.contains((x + dirs[toward][0]) + " " + (y + dirs[toward][1]))){
						x += dirs[toward][0];
						y += dirs[toward][1];
					}
				}
				ret = Math.max(ret, x*x + y*y);
			}
		}
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		WalkingRobotSimulation sol = new WalkingRobotSimulation();
		int[] commands = {4,-1,4,-2,4};
		int[][] obstacles = {{2, 4}};
		int ret = sol.robotSim(commands, obstacles);
		System.out.println(ret);
	}
}
