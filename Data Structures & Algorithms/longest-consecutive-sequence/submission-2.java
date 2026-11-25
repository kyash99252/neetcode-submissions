class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestSequence = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentSequence = 1;
                
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentSequence += 1;
                }

                longestSequence = Math.max(longestSequence, currentSequence);
            }
        }

        return longestSequence;
    }

    /*
    *   Time Complexity : O(n)
    *   Space Complexity : O(n)
    */
}
