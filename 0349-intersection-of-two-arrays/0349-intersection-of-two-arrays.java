class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();
        for (int n : nums1) s.add(n);

        Set<Integer> ans = new HashSet<>();
        for(int n : nums2)
        if (s.contains(n)) ans.add(n);
        return ans.stream().mapToInt(Integer::intValue).toArray();


        
    }
}