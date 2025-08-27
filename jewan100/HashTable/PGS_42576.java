import java.util.HashMap;

public class Solution {

	public static void main(String[] args) throws Exception {
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		System.out.println(solution(participant, completion));
	}

	public static String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> hm = new HashMap<>();
		for (String str : participant)
			hm.put(str, hm.getOrDefault(str, 0) + 1);
		for (String str : completion) {
			hm.put(str, hm.get(str) - 1);
			if (hm.get(str) == 0)
				hm.remove(str);
		}
		String answer = "";
		for (String str : hm.keySet())
			answer = str;
		return answer;
	}
}
