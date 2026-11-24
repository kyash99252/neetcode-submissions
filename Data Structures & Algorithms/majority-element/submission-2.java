class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int[] bit = new int[32];

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = 0; j < 32; j++) {
                bit[j] += num & 1;
                num >>= 1;
            }
        }

        for (int i = 0; i < 32; i++) {
            bit[i] = Math.min((2 * bit[i]) / n, 1);
        }

        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            ans |= (bit[i] << i);
        }

        return ans;
    }
}