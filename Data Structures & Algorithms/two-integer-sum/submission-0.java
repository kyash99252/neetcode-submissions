class Solution {
    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;

        Map<Integer, ArrayList<Integer>> numIndMap = new HashMap<>();

        for (int i = 0; i < size; i++) {
            numIndMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (int i = 0; i < size; i++) {
            int diff = target - nums[i];

            if (numIndMap.containsKey(diff)) {
                ArrayList<Integer> indices = numIndMap.get(diff);

                if (diff != nums[i]) {
                    return new int[]{i, indices.get(0)};
                } else if (indices.size() > 1) {
                    int otherIndex = indices.get(0) == i
                        ? indices.get(1)
                        : indices.get(0);

                    return new int[]{i, otherIndex};
                }
            }
        }

        return new int[0];
    }
}