class Solution {
    public int missingMultiple(int[] nums, int k) {
        int multi = k;
        while (true) {
            boolean ans = false;
            for (int i=0;i<nums.length;i++) {
                if (nums[i] == multi) {
                    ans  = true;
                    break;
                }
            }
            if (!ans) {
                return multi;
            }
            multi += k;
        }
    }
}
