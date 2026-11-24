class Solution {
    public int[] getConcatenation(int[] nums) {
        int size = nums.length;
        int[] new_nums = new int[2 * size];

        for (int i = 0; i < 2 * size; i++) {
            new_nums[i] = nums[i % size];
        }

        return new_nums;
    }
}