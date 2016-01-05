package structure.string.sort.application;

import structure.string.sort.MSD;

/**
 * find the longest repeated sub string of a sequence
 * 
 * 1. get the suffix of each position
 * 
 * 2. radix sort these suffix string and find the longest repeated
 * 
 * @author wuxu
 * @time 2016Äê1ÔÂ5ÈÕ
 */
public class LongestRepeatedSubString {

	public static String lrs(String data) {
		String[] suffix = new String[data.length()];

		// 1.get the suffix of each position O(n)
		for (int i = 0; i < data.length(); i++) {
			suffix[i] = data.substring(i, data.length());
		}

		// 2.sort the suffix array
		MSD.sort(suffix);

		// 3.find the longest repeated sub string
		String lrs = "";

		for (int i = 0; i < data.length() - 1; i++) {
			int len = lcp(suffix[i], suffix[i + 1]);
			if (len > lrs.length()) {
				lrs = suffix[i].substring(0, len);
			}
		}

		return lrs;
	}

	// longest common prefix of s and t
	private static int lcp(String s, String t) {
		int N = Math.min(s.length(), t.length());
		for (int i = 0; i < N; i++) {
			if (s.charAt(i) != t.charAt(i))
				return i;
		}
		return N;
	}

	public static void main(String[] args) {

		System.out.println(LongestRepeatedSubString.lrs("saddaasdqwrxdczxfafasfdasfqwdsdafsddfqwrwsdasdwqdsafsadqwe"));
	}
}
