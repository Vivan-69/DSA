class Solution {

    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        long left = 1;
        long right = 1L * k * getMin(coins);
        while (left < right) {
            long mid = left + (right - left) / 2;
            long count = countValid(mid, coins);
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private long countValid(long x, int[] coins) {
        long ans = 0;
        int n = coins.length;
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int selected = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    lcm = lcm(lcm, coins[i]);
                    selected++;
                }
            }
            long ways = x / lcm;
            if (selected % 2 == 1)
                ans += ways;
            else
                ans -= ways;
        }
        return ans;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private int getMin(int[] coins) {
        int min = coins[0];
        for (int coin : coins) {
            min = Math.min(min, coin);
        }
        return min;
    }
}