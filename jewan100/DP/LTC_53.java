public class Solution {

	public static void main(String[] args) throws Exception {
		System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8}));
	}

	public static int maxSubArray(int[] nums) {
		int max = nums[0];
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(nums[i], sum + nums[i]);
			max = Math.max(max, sum);
		}
		return max;
	}
}