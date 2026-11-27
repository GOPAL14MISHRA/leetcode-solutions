class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int cheapestItem = Integer.MAX_VALUE;
        int[] copies = new int[n];

        for (int i = 0; i < n; i++) {
            cheapestItem = Math.min(cheapestItem, items[i][1]);
            int copy = 0;
            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue;
                if (items[j][0] % items[i][0] == 0) {
                    copy++;
                }
            }
            copies[i] = copy;
        }
        int[][] dp = new int[n + 1][budget + 1];
        //base case

        for (int b = 0; b <= budget; b++) {
            dp[0][b] = b / cheapestItem;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= budget; j++) {
                int skip = dp[i - 1][j];
                int take = 0;
                int price = items[i - 1][1];
                if (price <= j) {
                 take = 1 + copies[i - 1] + dp[i - 1][j - price];
                }
                dp[i][j] = Math.max(skip, take);
            }
        }
        return dp[n][budget];
    }
}