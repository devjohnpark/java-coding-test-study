import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.out.println(letterCombinations(""));
	}

	static HashMap<Character, char[]> hs = new HashMap<>();
	static List<String> ls = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static char[] cArr;

	static {
		hs.put('2', new char[]{'a', 'b', 'c'});
		hs.put('3', new char[]{'d', 'e', 'f'});
		hs.put('4', new char[]{'g', 'h', 'i'});
		hs.put('5', new char[]{'j', 'k', 'l'});
		hs.put('6', new char[]{'m', 'n', 'o'});
		hs.put('7', new char[]{'p', 'q', 'r', 's'});
		hs.put('8', new char[]{'t', 'u', 'v'});
		hs.put('9', new char[]{'w', 'x', 'y', 'z'});
	}

	public static List<String> letterCombinations(String digits) {
		cArr = digits.toCharArray();
		if (cArr.length == 0)
			return new ArrayList<>();
		recursive(0);
		return ls;
	}

	private static void recursive(int depth) {
		if (depth == cArr.length) {
			ls.add(sb.toString());
			return;
		}
		for (int i = 0; i < hs.get(cArr[depth]).length; i++) {
			sb.append(hs.get(cArr[depth])[i]);
			recursive(depth + 1);
			sb.deleteCharAt(depth);
		}
	}
}
// 재귀보다는 반복문 4개로 푸는 게 가장 빠름