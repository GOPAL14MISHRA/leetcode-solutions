class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int cheapestItem = Integer.MAX_VALUE;
        int[] copies = new int[n];
        int[][] memo = new int[n + 1][budget + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
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
        return solve(n, budget, items, copies, cheapestItem,memo);

    }

    private int solve(int n, int budget, int[][] items, int[] copies, int cheapestItem,int[][] memo) {
        if (n == 0) {
            return budget / cheapestItem;
        }
        if (memo[n][budget] != -1) {
            return memo[n][budget];
        }
        int take = 0;
        int skip = 0;
        int price = items[n - 1][1];
        if (price <= budget) {
            take = 1 + copies[n - 1] + solve(n - 1, budget - price, items, copies, cheapestItem,memo);
        }
        skip = solve(n - 1, budget, items, copies, cheapestItem,memo);
        return memo[n][budget] = Math.max(skip, take);
    }
}