class Solution {
    int solve(int[] nums, int i, int j) {
        //int n = nums.length;
        if (i == j)
            return nums[i];
        int Left = nums[i] - solve(nums, i + 1, j);
        int Right = nums[j] - solve(nums, i, j - 1);
        int ans = Math.max(Left, Right);
        return ans;
    }

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        return solve(nums, 0, n - 1) >= 0;
    }
}