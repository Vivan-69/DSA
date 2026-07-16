class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            pre[i] = gcd(nums[i], max);
        }
        Arrays.sort(pre);
        long sum = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            sum += gcd(pre[l], pre[r]);
            l++;
            r--;
        }
        return sum;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}