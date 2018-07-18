package easy.string;

/**
 * You are given a string representing an attendance record for a student. The
 * record only contains the following three characters: 'A' : Absent. 'L' :
 * Late. 'P' : Present. A student could be rewarded if his attendance record
 * doesn't contain more than one 'A' (absent) or more than two continuous 'L'
 * (late). You need to return whether the student could be rewarded according to
 * his attendance record.
 * 
 * @author wenhanglei
 *
 */
public class StudentAttendanceRecordI {
	/*
	 * 思路：
	 */
	public boolean checkRecord(String s) {
		if(s == null || s.length() == 0) return true;
		int Anum = 0, Lnum = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == 'L'){
				Lnum++;
			}else {
				if(s.charAt(i) == 'A')
					Anum++;
				Lnum = 0;
			}
			if(Anum == 2 || Lnum == 3) return false;
		}
		return true;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		StudentAttendanceRecordI sol = new StudentAttendanceRecordI();
		boolean ret = sol.checkRecord("PPALLP");
		System.out.println(ret);
	}
}
