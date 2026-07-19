class Solution {
    public int findGCD(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MIN_VALUE;
        for (int val : nums) {
            if (val < small)
                small = val;
            if (val > big)
                big = val;
        }
        return gcd(small, big);
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}