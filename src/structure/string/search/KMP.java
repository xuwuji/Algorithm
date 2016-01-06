package structure.string.search;

/**
 * 
 * @author wuxu
 * @time 2016Äê1ÔÂ6ÈÕ
 */
public class KMP {
	private final int R; // the radix
	private int[][] dfa; // the KMP automoton
	private String pattern; // or the patterntern string

	/**
	 * Preprocesses the patterntern string.
	 *
	 * @param pattern
	 *            the patterntern string
	 */
	public KMP(String pattern) {
		this.R = 256;
		this.pattern = pattern;

		// build DFA from patterntern
		int M = pattern.length();
		dfa = new int[R][M];
		dfa[pattern.charAt(0)][0] = 1;
		for (int X = 0, j = 1; j < M; j++) {
			for (int c = 0; c < R; c++)
				dfa[c][j] = dfa[c][X]; // Copy mismatch cases.
			dfa[pattern.charAt(j)][j] = j + 1; // Set match case.
			X = dfa[pattern.charAt(j)][X]; // Update restart state.
		}
	}

	/**
	 * Returns the index of the first occurrrence of the patterntern string in
	 * the text string.
	 *
	 * @param txt
	 *            the text string
	 * @return the index of the first occurrence of the patterntern string in
	 *         the text string; N if no such match
	 */
	public int search(String txt) {

		// simulate operation of DFA on text
		int M = pattern.length();
		int N = txt.length();
		int i, j;
		for (i = 0, j = 0; i < N && j < M; i++) {
			j = dfa[txt.charAt(i)][j];
		}
		if (j == M)
			return i - M; // found
		return N; // not found
	}

	public static void main(String[] args) {
		String txt = "abacadabrabracabracadabrabrabracad";
		KMP kmp1 = new KMP("rabrabracad");
		int offset1 = kmp1.search(txt);
		System.out.println(offset1);
	}
}
