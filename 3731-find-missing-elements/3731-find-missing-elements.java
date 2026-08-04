class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int val = nums[i] + 1; val < nums[i + 1]; val++) {
                res.add(val);
            }
        }
        return res;
    }
}