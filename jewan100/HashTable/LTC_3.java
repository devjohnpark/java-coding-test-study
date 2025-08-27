import java.util.HashSet;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

	public static int lengthOfLongestSubstring(String s) {
		HashSet<Character> hs = new HashSet<>();
		int l = 0, r = 0, maxLen = 0;
		for (; r < s.length(); r++) {
			while (hs.contains(s.charAt(r)))
				hs.remove(s.charAt(l++));
			hs.add(s.charAt(r));
			maxLen = Math.max(maxLen, r - l + 1);
		}
		return maxLen;
	}
}
