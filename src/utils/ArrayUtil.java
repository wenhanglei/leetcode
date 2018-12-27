package utils;

import java.util.LinkedList;
import java.util.List;

public class ArrayUtil {
	
	public static List<Integer> getList(int[] arr){
		List<Integer> list = new LinkedList<>();
		for(int i = 0; i < arr.length; i++){
			list.add(arr[i]);
		}
		return list;
	}

}
