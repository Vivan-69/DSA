class Solution {
    public int missingInteger(int[] nums) {
        int sequence = nums[0];
        int i = 1;
        while (i < nums.length && nums[i] == nums[i - 1] + 1) {
            sequence += nums[i];
            i++;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int candidate = sequence;
        while (set.contains(candidate)) {
            candidate++;
        }
        return candidate;
    }
}