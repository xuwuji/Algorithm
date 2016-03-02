package structure.string.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class StringBasic {

	/**
	 * find the first nonrepeated character
	 * 
	 * Write an efficient function to find the fiFrst nonrepeated character in a
	 * string. For instance, the first nonrepeated character in “total” is 'o'
	 * and the first nonrepeated character in “teeter” is 'r'. Discuss the
	 * efficiency of your algorithm.
	 */

	public static String firstNonRepeated(String str) {
		char[] charArray = str.toCharArray();
		HashMap<Character, Integer> map = new HashMap();
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		for (int i = 0; i < charArray.length; i++) {
			if (map.get(charArray[i]) == 1) {
				return String.valueOf(charArray[i]);
			}
		}
		return null;
	}

	/**
	 * remove specific characters
	 */

	public static String removeChars(String origin, String remove) {
		StringBuilder sb = new StringBuilder();
		char[] originChar = origin.toCharArray();
		HashSet<Character> set = new HashSet();
		for (int i = 0; i < remove.length(); i++) {
			set.add(remove.charAt(i));
		}
		for (char c : originChar) {
			if (!set.contains(c)) {
				sb.append(String.valueOf(c));
			}
		}
		return sb.toString();
	}

	/**
	 * reverse a sentence with words. each word is space delimited
	 * 
	 * 
	 * 
	 * 
	 * @param args
	 */

	public static String reverseWords(String origin) {
		return null;
	}

	/**
	 * convert a string to an integer
	 * 
	 * * You may assume that the string contains only digits and the minus
	 * character ('-'), that it is a properly formatted integer number, and that
	 * the number is within the range of an int type. The second routine
	 * converts a signed integer stored as an int back to a string.
	 * 
	 * @param str
	 * @return
	 */
	public static int StringToInteger(String str) {
		int result = 0;
		int i = 0;
		boolean isNegative = false;
		if (str.charAt(0) == '-') {
			isNegative = true;
			i++;
		}
		while (i < str.length()) {
			result *= 10;
			result += str.charAt(i) - '0';
			i++;
		}
		if (isNegative) {
			result = -result;
		}
		return result;
	}

	/**
	 * convert an integer to a string
	 * 
	 * @param num
	 * @return
	 */
	public static String IntegerToString(int num) {
		int temp = num;
		int length = 0;
		boolean isNegative = false;
		if (num < 0) {
			isNegative = true;
			num = -num;
		}
		// use do-while make sure the loop body at least run once
		// when the num is 0, the length should be 1 not 0, so the loop body
		// should run for one time
		do {
			temp /= 10;
			length++;
		} while (temp != 0);
		char[] array = new char[length];
		int i = 0;
		do {
			array[i++] = (char) (num % 10 + '0');
			num /= 10;
		} while (num != 0);
		StringBuilder sb = new StringBuilder();
		if (isNegative) {
			sb.append("-");
		}
		for (int j = array.length - 1; j >= 0; j--) {
			sb.append(String.valueOf(array[j]));
		}
		return sb.toString();
	}

	/**
	 * determine if each character in the string is unique,cannot use additional
	 * data structure
	 * 
	 * 1.use a check array
	 * 
	 * 2.sort the string, and compare one character with its neighbor
	 * 
	 * ASCII ->1 bytes, 8 bits, 256
	 * 
	 * Unicode ->2 bytes, 16 bits, 65536
	 * 
	 * Here we assume the string is ASCII
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isUnique(String str) {
		boolean[] check = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (check[val] == true) {
				return false;
			}
			check[val] = true;
		}
		return true;
	}

	/**
	 * check two string consists of same characters
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean isAnagram(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		HashMap<Character, Integer> map = new HashMap();
		// 1. count each character in first String
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		// 2. compare the second string
		for (int i = 0; i < b.length(); i++) {
			char c = b.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
			} else {
				return false;
			}
		}

		// 3. check the map
		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() != 0) {
				return false;
			}
		}
		return true;

	}

	/**
	 * use array as check helper instead of hashMap above,assume the string is
	 * ASCII
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean isAnagram2(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		int[] check = new int[256];
		for (int i = 0; i < a.length(); i++) {
			int c = a.charAt(i);
			check[c]++;
		}
		for (int i = 0; i < b.length(); i++) {
			int c = b.charAt(i);
			check[c]--;
			if (check[c] < 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(StringBasic.removeChars("i love you", "io"));
		System.out.println(StringBasic.StringToInteger("100"));
		System.out.println(StringBasic.IntegerToString(0));
		System.out.println(StringBasic.isAnagram("abc", "bac"));
	}
}
