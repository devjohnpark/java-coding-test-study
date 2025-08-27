import java.util.Arrays;

public class LTC_706 {

	int[] arr;

	public LTC_706() {
		arr = new int[1_000_001];
		Arrays.fill(arr, -1);
	}

	public void put(int key, int value) {
		arr[key] = value;
	}

	public int get(int key) {
		return arr[key];
	}

	public void remove(int key) {
		arr[key] = -1;
	}
}