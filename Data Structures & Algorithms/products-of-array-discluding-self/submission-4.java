class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int zero = 0, neg = 0;
        int[][] prefix = new int[n][2];

        for (int num : nums) {
            if (num == 0) zero++;
            else if (num < 0) neg++;
        }

        prefix[0][0] = 1;
        prefix[n - 1][1] = 1;

        for (int i = 1; i < n; i++) {
            prefix[i][0] = prefix[i - 1][0] * Math.abs(nums[i - 1]);
            prefix[n - i - 1][1] = prefix[n - i][1] * Math.abs(nums[n - i]);
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int prod = prefix[i][0] * prefix[i][1];

            if (zero > 0) {
                if (nums[i] == 0 && zero == 1) {
                    ans[i] = (neg % 2 == 0) ? prod : -prod;
                } else {
                    ans[i] = 0;
                }
            } else {
                int remainingNeg = neg - (nums[i] < 0 ? 1 : 0);
                ans[i] = (remainingNeg % 2 == 0) ? prod : -prod;
            }
        }

        return ans;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)