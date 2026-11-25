class Solution {
    static final long MOD = 1000000007L;
    static final long BASE = 911382323L;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        long[] power = new long[n + 1];
        power[0] = 1;
        for (int i = 0; i < n; i++) {
            long val = (long)nums[i] - Integer.MIN_VALUE + 1;
            prefix[i + 1] = (prefix[i] * BASE + val) % MOD;
            power[i + 1] = power[i] * BASE % MOD;
        }
        int left = 1;
        int right = n;
        int ans = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (hasUnique(mid, n, prefix, power)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean hasUnique(int len, int n, long[] prefix, long[] power) {
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i + len <= n; i++) {
            int j = i + len;
            long hash = (prefix[j] - prefix[i] * power[len] % MOD + MOD) % MOD;
            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }
        for (int frq : map.values()) {
            if (frq == 1) {
                return true;
            }
        }
        return false;
    }
}