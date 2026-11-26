class Solution {
    public boolean canAliceWin(int n) {
        if(n<10)return false;
        boolean turnAlice = true;
        boolean turnBob = false;
        n = n - 10;
        int prev = 10;
        turnAlice = false;
        turnBob = true;
        while (n >= 0) {
            if (turnBob) {
                if (n < prev - 1){
                    return true;
                }

                else {
                    n = n - (prev - 1);
                    prev=prev-1;
                    if(n==0)return false;
                    turnBob = false;
                    turnAlice = true;
                }
            }
            if (turnAlice) {
                if (n < prev - 1)
                    return false;
                else {
                    n = n - (prev - 1);
                    prev=prev-1;
                    if(n==0)return true;
                    turnAlice = false;
                    turnBob = true;

                }
            }
        }
        return false;
    }
}