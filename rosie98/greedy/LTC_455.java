class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int result = 0;
        int gp = 0;
        int sp = 0;

        while(true) {
            if (gp == g.length || sp == s.length) {
                break;
            }
            
            if (g[gp] <= s[sp]) {
                gp++;
                result++;
            } 

            sp++;
        }

        return result;
    }
}