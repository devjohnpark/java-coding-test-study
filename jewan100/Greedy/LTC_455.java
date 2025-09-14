import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws Exception {
		int[] g = {1, 2, 3}, s = {1, 1};
		System.out.println(findContentChildren(g, s));
	}
	public static int findContentChildren(int[] g, int[] s) {
		int n = g.length, m = s.length;
		Arrays.sort(g);
		Arrays.sort(s);
		int i = 0, j = 0;
		while (i < n && j < m) {
			if (g[i] <= s[j]) {
				i++;
				j++;
			} else
				j++;
		}
		return i;
	}
}
// 출발 지점 찾기