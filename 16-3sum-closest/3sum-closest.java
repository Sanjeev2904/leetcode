class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length < 3) return -1;

        // sort nums
        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];

        // traverse k
        for (int k = nums.length - 1; k >= 2; k--) {
            int largestSmallerPairSum = getLargestPairSum(nums, target - nums[k], k);
            int smallestLargerPairSum = getSmallestPairSum(nums, target - nums[k], k);

            if (largestSmallerPairSum != Integer.MIN_VALUE && isCloser(target, result, largestSmallerPairSum + nums[k])) result = largestSmallerPairSum + nums[k];

            if (smallestLargerPairSum != Integer.MAX_VALUE && isCloser(target, result, smallestLargerPairSum + nums[k])) result = smallestLargerPairSum + nums[k];
        }

        return result;
    }

    // Helpers
    // return true if newValue is closer to target
    private boolean isCloser(int target, int oldValue, int newValue) {
        return Math.abs(newValue - target) < Math.abs(oldValue - target);
    }

    // find Largest Pair sum of nums[i] + nums[j] that is smaller or equal to target (target - nums[k]), where i, j < k.
    // return Integer.MIN_VALUE if no pair sum is valid
    // Assert there are at least 2 elements before k
    private int getLargestPairSum(int[] nums, int target, int k) {
        int left = 0;
        int right = k - 1;

        int bestSum = Integer.MIN_VALUE;

        while (left < right) {
            int goal = target - nums[right];

            if (nums[left] <= goal) {
                if (nums[left] + nums[right] > bestSum) bestSum = nums[left] + nums[right];
                while (left < right && left + 1 < nums.length && nums[left] == nums[left + 1]) left++; // deduplicates of left
                left++; // move left
            } else {
                while (left < right && nums[right] == target - goal) right--; // deduplicates & move right
            }
        }

        return bestSum;
    }

    // find Smallest Pair sum of nums[i] + nums[j] that is larger than target (target - nums[k]), where i, j < k.
    // return Integer.MAX_VALUE if no pair sum is valid
    // Assert there are at least 2 elements before k
    private int getSmallestPairSum(int[] nums, int target, int k) {
        int left = 0;
        int right = k - 1;

        int bestSum = Integer.MAX_VALUE;

        while (left < right) {
            int goal = target - nums[right];

            if (nums[left] > goal) {
                if (nums[left] + nums[right] < bestSum) bestSum = nums[left] + nums[right];
                while (left < right && nums[right] == target - goal) right--; // deduplicates & move right
            } else {
                while (left < right && left + 1 < nums.length && nums[left] == nums[left + 1]) left++; // deduplicates of left
                left++; // move left
            }
        }

        return bestSum;
    }
}