class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0, right = n - 1;

        if (n == 1 && nums[0] != val) return 1;

        while (true) {
            if (left > right) return left;

            if (nums[left] == val) {
                while (nums[right] == val) {
                    right--;
                    if (right <= left) return left;
                }

                nums[left] = nums[right];
                nums[right] = val;

                right--;
            }
            left++;
        }
    }
}