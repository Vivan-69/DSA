class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 8; i++) {
            q.add(i);
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr >= low && curr <= high) {
                ans.add(curr);
            }

            if (curr > high) {
                continue;
            }
            int lastDigit = curr % 10;
            if (lastDigit < 9) {
                int nextNum = curr * 10 + (lastDigit + 1);
                q.add(nextNum);
            }
        }
        return ans;
    }
}