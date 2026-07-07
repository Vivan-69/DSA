class Solution {
    public long sumAndMultiply(int n) {
        long rev = 0;
        long sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            if (digit != 0) {
                rev = rev * 10 + digit;
            }
            n /= 10;
        }
        long x = 0;
        long temp = rev;
        while (temp > 0) {
            x = x * 10 + (temp % 10);
            temp /= 10;
        }
        return x * sum;
    }
}