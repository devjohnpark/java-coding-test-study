import java.util.HashSet;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.out.println(numJewelsInStones("aA", "aAAAAA"));
	}

	public static int numJewelsInStones(String jewels, String stones) {
		HashSet<Character> hs = new HashSet<>();
		for (char c : jewels.toCharArray())
			hs.add(c);
		int count = 0;
		for (char c : stones.toCharArray())
			if (hs.contains(c))
				count++;
		return count;
	}
}