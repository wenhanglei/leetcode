package medium.string;


/**
 * Compare two version numbers version1 and version2. If version1 > version2
 * return 1; if version1 < version2 return -1;otherwise return 0. You may assume
 * that the version strings are non-empty and contain only digits and the .
 * character. The . character does not represent a decimal point and is used to
 * separate number sequences.
 * 
 * @author wenhanglei
 */
public class CompareVersionNumbers {
	/*
	 * 思路： 将字符串整数依次比较即可
	 */
	public int compareVersion(String version1, String version2) {
		int[] nVersion1 = getNumVersion(version1);
		int[] nVersion2 = getNumVersion(version2);
		if(nVersion1.length == nVersion2.length){
			for(int i = 0; i < nVersion1.length; i++){
				if(nVersion1[i] < nVersion2[i]) return -1;
				else if(nVersion1[i] > nVersion2[i]) return 1;
			}
		}else if(nVersion1.length > nVersion2.length){
			for(int i = 0; i < nVersion1.length; i++){
				if(i < nVersion2.length){
					if(nVersion1[i] < nVersion2[i]) return -1;
					else if(nVersion1[i] > nVersion2[i]) return 1;
				}else if(nVersion1[i] != 0 ) return 0;
			}
		}else {
			for(int i = 0; i < nVersion2.length; i++){
				if(i < nVersion1.length){
					if(nVersion1[i] < nVersion2[i]) return -1;
					else if(nVersion1[i] > nVersion2[i]) return 1;
				}else if(nVersion2[i] != 0) return 0;
			}
		}
		return 0;
	}
	
	private int[] getNumVersion(String version){
		String[] strs = version.split(".");
		int[] numVersion = new int[strs.length];
		for(int i = 0; i < strs.length; i++){
			numVersion[i] = Integer.parseInt(strs[i]);
		}
		return numVersion;
	}
	
	/**
	 * 测试函数
	 */
	public static void main(String[] args) {
		
	}
}
