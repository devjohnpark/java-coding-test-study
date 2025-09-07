import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) throws Exception {
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		System.out.println(solution(tickets));
	}

	public static String[] solution(String[][] tickets) {
		HashMap<String, PriorityQueue<String>> hm = new HashMap<>();
		for (String[] ticket : tickets) {
			String from = ticket[0];
			String to = ticket[1];
			hm.putIfAbsent(from, new PriorityQueue<>());
			hm.putIfAbsent(to, new PriorityQueue<>());
			hm.get(from).add(to);
		}
		Deque<String> dq = new ArrayDeque<>();
		Deque<String> eulerPath = new ArrayDeque<>();
		dq.offer("ICN");
		while (!dq.isEmpty()) {
			String from = dq.peekLast();
			if (!hm.get(from).isEmpty())
				dq.offer(hm.get(from).poll());
			else
				eulerPath.offerFirst(dq.pollLast());
		}
		int len = eulerPath.size();
		String[] answer = new String[len];
		for (int i = 0; i < len; i++)
			answer[i] = eulerPath.poll();
		return answer;
	}
}

// 모든 티켓 사용 = 오일러 경로