class Solution {
    public int uniqueXorTriplets(int[] nums) {
        HashSet<Integer> pairXor = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXor.add(nums[i] ^ nums[j]);
            }
        }
        HashSet<Integer> ans = new HashSet<>();
        for (int p : pairXor) {
            for (int x : nums) {
                ans.add(p ^ x);
            }
        }
        return ans.size();
    }
}