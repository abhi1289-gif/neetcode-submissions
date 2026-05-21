class Solution {
    public int reverse(int x) {
        boolean neg = false;
        if(x<0){
            neg = true;
            x = x*(-1);
        }

        long temp = 0;

        while(x > 0){
            temp = temp*10 + x%10;
            x = x/10;
        }

        if(neg){
            temp = temp*(-1);
            if(temp < Integer.MIN_VALUE){
                return 0;
            }
            return (int)(temp);
        }
        else{
            if(temp > Integer.MAX_VALUE) return 0;
        }

        return (int)(temp);
    }
}
