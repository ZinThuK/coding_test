package code.test.ans.java.modules;

import java.util.Arrays;
import java.util.Collections;

public class ModuleTwo {
	public int findKthLargest(int[] nums, int k) {
		// 配列を降順にソート
		nums = Arrays.stream(nums).boxed()
	    .sorted(Collections.reverseOrder())
	    .mapToInt(Integer::intValue)
	    .toArray();

		// k番目に大きい要素はインデックス k-1 にある（0始まりのため）
		System.out.println("k = " +k);
		System.out.println("After sorting nums: " + Arrays.toString(nums));
		System.out.println("Index Number: " + (k - 1));
		System.out.println("Value: " + nums[k - 1]);

		return nums[k - 1];
	}
}
