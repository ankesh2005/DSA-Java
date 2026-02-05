public class TransformedArray {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (x > 0) {
                int idx = (i + x) % n;
                result[i] = nums[idx];
            } else if (x < 0) {
                int idx = (i +x)%n;
                if (idx >= 0) {
                    result[i] = nums[idx];
                } else {
                    result[i] = nums[(n + idx)%n];
                }
            } else {
                result[i] = nums[i];
            }
        }
        return result;
    }
}
