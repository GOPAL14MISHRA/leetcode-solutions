class Solution {
    public boolean checkString(String s) {
       //find first occurance of b,then from there to end if a found return false else return true
       int i=0;
       int n=s.length();
        while(i<n && s.charAt(i)!='b'){
            i++;
        }
        while(i<n){
            if(s.charAt(i)=='a'){
                return false;
            }
            i++;
        }
        return true;
    }
}