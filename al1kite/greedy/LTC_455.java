import java.util.*;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // 아이 요구치 오름차순
        Arrays.sort(s); // 쿠키 크기 오름차순

        int i = 0; // 아이 포인터
        int j = 0; // 쿠키 포인터
        int content = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) { // 이 쿠키로 이 아이를 만족 가능
                content++;
                i++; // 다음 아이
                j++; // 다음 쿠키
            } else {
                j++; // 쿠키가 작아서 이 아이를 만족 못함 -> 더 큰 쿠키로
            }
        }
        return content;
    }
}
