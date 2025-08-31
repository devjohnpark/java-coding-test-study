import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) throws Exception {
		List<List<String>> tickets = new ArrayList<>();
		tickets.add(List.of("JFK", "SFO"));
		tickets.add(List.of("JFK", "ATL"));
		tickets.add(List.of("SFO", "ATL"));
		tickets.add(List.of("ATL", "JFK"));
		tickets.add(List.of("ATL", "SFO"));
		System.out.println(findItinerary(tickets));
	}

	public static List<String> findItinerary(List<List<String>> tickets) {
		HashMap<String, PriorityQueue<String>> hm = new HashMap<>();
		for (List<String> ticket : tickets) {
			String from = ticket.get(0), to = ticket.get(1);
			hm.putIfAbsent(from, new PriorityQueue<String>());
			hm.putIfAbsent(to, new PriorityQueue<String>());
			hm.get(from).add(to);
		}
		Deque<String> dq = new ArrayDeque<>();
		Deque<String> eulerPath = new ArrayDeque<>();
		dq.offer("JFK");
		while (!dq.isEmpty()) {
			String from = dq.peekLast();
			if (!hm.get(from).isEmpty())
				dq.offer(hm.get(from).poll());
			else
				eulerPath.offerFirst(dq.pollLast());
		}
		return new ArrayList<>(eulerPath);
	}
}

// 모든 티켓 사용 = 오일러 경로