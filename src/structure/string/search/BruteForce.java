package structure.string.search;

/**
 * 
 * @author wuxu
 * @time 2016Äê1ÔÂ6ÈÕ
 */
public class BruteForce {

	public int search1(String pattern, String txt) {
		int m = pattern.length();
		int n = txt.length();
		for (int i = 0; i < n - m; i++) {
			int pointer = 0;
			for (; pointer < m; pointer++) {
				if (txt.charAt(i + pointer) != pattern.charAt(pointer)) {
					break;
				}
			}
			if (pointer == m) {
				return i;
			}
		}
		return -1;
	}

	public int search2(String pattern, String txt) {
		int m = pattern.length();
		int n = txt.length();
		int i = 0, j = 0;
		for (; i < n && j < m; i++) {
			if (txt.charAt(i + j) == pattern.charAt(j)) {
				j++;
			} else {
				i = i - j;
				j = 0;
			}
		}
		if (j == m) {
			return i - m;
		} else {
			return -1;
		}
	}

}
