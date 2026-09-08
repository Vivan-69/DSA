class Solution {
    public int countCommas(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            int length = 0;
            int temp = i;
            while (temp > 0) {
                length++;
                temp /= 10;
            }
            total += Math.max(0, (length - 4) / 3 + ((length - 1) / 3));
        }
        return total;
    }
}