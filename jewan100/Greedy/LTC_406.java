import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws Exception {
		int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
		System.out.println(reconstructQueue(people));
	}
	public static int[][] reconstructQueue(int[][] people) {
		int n = people.length;
		Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
		ArrayList<int[]> al = new ArrayList<>();
		for (int i = 0; i < n; i++)
			al.add(people[i][1], people[i]);
		int[][] answer = new int[n][];
		for (int i = 0; i < n; i++)
			answer[i] = al.get(i);
		return answer;
	}
}
// 정렬 후 삽입