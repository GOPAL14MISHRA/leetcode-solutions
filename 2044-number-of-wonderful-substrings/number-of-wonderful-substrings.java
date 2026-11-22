class Solution {
    public long wonderfulSubstrings(String word) {
        Map<Integer,Long> mpp=new HashMap<>();
        mpp.put(0, 1L);
        int mask=0;
        long ans=0;
        for(int i=0;i<word.length();i++){
            int bit=word.charAt(i)-'a';
            mask^=(1<<bit);
            // Case 1: All characters have even frequency
            ans+=mpp.getOrDefault(mask,0L);

            for(int j=0;j<10;j++){
                int newMask=mask^(1<<j);
                ans+=mpp.getOrDefault(newMask,0L);
            }
            mpp.put(mask,mpp.getOrDefault(mask,0L)+1);
        }
        return ans;
    }
}