package medium.array;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * @author wenhanglei
 */
public class MergeIntervals {
	/*
	 * 思路：先对list进行排序，再遍历检查获得新的上下界
	 */
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> ret = new LinkedList<>();
		//边界检查
		if(intervals == null || intervals.size() == 0) return ret;
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start < o2.start) return -1;
				else if(o1.start > o2.start) return 1;
				else return 0;
			}
		});
		Iterator<Interval> iterator = intervals.iterator();
		Interval curr = iterator.next();
		int preStart = curr.start;
		int preEnd = curr.end;
		while(curr != null){
			curr = iterator.hasNext()?iterator.next():null;
			while(curr != null && curr.start <= preEnd){
				preEnd = Math.max(preEnd, curr.end);
				curr = iterator.hasNext()?iterator.next():null;
			}
			ret.add(new Interval(preStart, preEnd));
			if(curr != null) {
				preStart = curr.start;
				preEnd = curr.end;
			}
		}
		return ret;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		List<Interval> list = new LinkedList<>();
//		list.add(new Interval(1, 3));
//		list.add(new Interval(8, 10));
//		list.add(new Interval(2, 6));
//		list.add(new Interval(15, 18));
		list.add(new Interval(1, 4));
		list.add(new Interval(2, 3));
		MergeIntervals sol = new MergeIntervals();
		List<Interval> ret = sol.merge(list);
		System.out.println(ret);
	}
}
