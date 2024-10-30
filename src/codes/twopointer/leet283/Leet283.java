package codes.twopointer.leet283;

public class Leet283 {
	public void moveZeroes(int[] nums) {
		int sortIdx = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[sortIdx] = nums[i];
				sortIdx++;
			}
		}

		while (sortIdx < nums.length) {
			nums[sortIdx] = 0;
			sortIdx++;
		}
	}
}
