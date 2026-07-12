class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] sort = arr.clone();
        Arrays.sort(sort);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int num : sort) {
            if (!map.containsKey(num)) {
                map.put(num, rank);
                rank++;
            }
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = map.get(arr[i]);
        }
        return result;
    }
}