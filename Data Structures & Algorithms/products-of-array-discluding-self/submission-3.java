class Solution {
    public int[] productExceptSelf(int[] nums) {
        int numNeg = 0, numZero = 0;
        int product = 1;

        for (int num : nums) {
            if (num == 0) {
                numZero++;
                continue;
            } else if (num < 0) {
                numNeg++;
            }

            product *= Math.abs(num);
        }

        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (numZero > 0) {
                if (nums[i] == 0 && numZero == 1) {
                    ans[i] = (numNeg % 2 == 0) ? product : -product;
                } else {
                    ans[i] = 0;
                }
            } else {
                int result = product / Math.abs(nums[i]);

                if ((numNeg - (nums[i] < 0 ? 1 : 0)) % 2 != 0) {
                    result = -result;
                }

                ans[i] = result;
            }
        }

        return ans;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
}