import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.out.println(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
	}

	public static int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int n : nums)
			hm.put(n, hm.getOrDefault(n, 0) + 1);
		ArrayList<int[]> al = new ArrayList<>();
		for (int n : hm.keySet())
			al.add(new int[]{n, hm.get(n)});
		al.sort((o1, o2) -> o2[1] - o1[1]);
		int[] arr = new int[k];
		for (int i = 0; i < k; i++)
			arr[i] = al.get(i)[0];
		return arr;
	}
}
