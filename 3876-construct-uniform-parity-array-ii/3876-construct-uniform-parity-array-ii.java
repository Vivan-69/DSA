class Solution {
    public boolean uniformArray(int[] nums) {
        int small = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 == 1)
                small = Math.min(small, num);
        }
        if (small == Integer.MAX_VALUE)
            return true;
        for (int num : nums) {
            if (num % 2 == 0 && num <= small)
                return false;
        }
        return true;
    }
}