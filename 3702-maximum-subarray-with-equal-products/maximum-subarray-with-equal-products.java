class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen=0;
        for(int i=0;i<n;i++){
            long gcd=0;
            long lcm=1;
            long product=1;
            for(int j=i;j<n;j++){
               product*=nums[j];
               gcd=findGcd(gcd,nums[j]);
               lcm = findlcm(lcm, nums[j]);
               if(product==(gcd*lcm)){
                maxLen=Math.max(maxLen,(j-i+1));
               }
               if (product > 1e18) {
                    break;
                }
            }
        }
        return maxLen;
    }
    private long findGcd(long a,long b){
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    private long findlcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return (a / findGcd(a, b)) * b;
    }
}