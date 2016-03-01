package structure.string.basic;

import java.util.HashMap;
import java.util.HashSet;

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

	public static void main(String[] args) {
		System.out.println(StringBasic.removeChars("i love you", "io"));
		System.out.println(StringBasic.StringToInteger("100"));
		System.out.println(StringBasic.IntegerToString(0));
	}
}
