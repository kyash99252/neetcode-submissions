class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(0, nums.length, nums);
    }

    private int[] mergeSort(int left, int right, int[] nums) {
        if (right - left == 1) {
            return new int[]{nums[left]};
        }
        
        int mid = (left + right) >> 1;

        int[] leftArr = mergeSort(left, mid, nums);
        int[] rightArr = mergeSort(mid, right, nums);

        return sort(leftArr, rightArr);
    }

    private int[] sort(int[] leftArr, int[] rightArr) {
        int left = 0, right = 0;
        int n = leftArr.length, m = rightArr.length;
        int[] sortedArr = new int[n + m];
        
        int index = 0;
        while (left < n && right < m) {
            if (leftArr[left] <= rightArr[right]) {
                sortedArr[index] = leftArr[left];
                left++;
            } else {
                sortedArr[index] = rightArr[right];
                right++;
            }
            index++;
        }

        while (left < n) {
            sortedArr[index] = leftArr[left];
            left++;
            index++;
        }

        while (right < m) {
            sortedArr[index] = rightArr[right];
            right++;
            index++;
        }

        return sortedArr;
    }
}