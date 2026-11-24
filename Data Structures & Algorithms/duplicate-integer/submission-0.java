class Solution {
    public boolean hasDuplicate(int[] nums) {
        int size = nums.length;

        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        boolean hasDuplicate = (nums.length == set.size()) ? false : true;
        return hasDuplicate;
    }
}