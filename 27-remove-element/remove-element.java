class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[count] = nums[j];
                count++;
            }
        }
        return count;
    }
}
