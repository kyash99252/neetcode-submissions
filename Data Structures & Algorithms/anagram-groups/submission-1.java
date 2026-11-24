class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int[] mask = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                mask[strs[i].charAt(j) - 'a']++;
            }
            String str_mask = Arrays.stream(mask).mapToObj(String::valueOf).collect(Collectors.joining("#"));
            map.computeIfAbsent(str_mask, k -> new ArrayList<>()).add(i);
        }

        List<List<String>> ans = new ArrayList<>();
        map.forEach((key, value) -> {
            List<String> temp = new ArrayList<>();
            for (int index : value) {
                temp.add(strs[index]);
            }
            ans.add(temp);
        });

        return ans;
    }
}
