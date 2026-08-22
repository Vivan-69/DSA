class Solution {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int sum = 0;
        int pro = 1;
        while (temp >= 1) {
            int d = temp % 10;
            sum += d;
            pro *= d;
            temp /= 10;
        }
        int total = sum + pro;
        return n % total == 0;
    }
}