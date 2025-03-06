package code.test.ans.java.modules;

import java.util.Arrays;

public class ModuleTwo {
	    public int findKthLargest(int[] nums, int k) {
	        // 配列を降順にソート
	        Arrays.sort(nums);
	        
	        // k番目に大きい要素はインデックス k-1 にある（0始まりのため）
	        return nums[nums.length - k];
	    }
	}
