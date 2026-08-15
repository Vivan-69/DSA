class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor = 0;
        int countZero = 0;
        for (int num : nums) {
            xor ^= num;
            if (num == 0) {
                countZero++;
            }
        }
        if (xor != 0) {
            return n;
        }
        if (countZero == n) {
            return 0;
        }
        return n - 1;
    }
}