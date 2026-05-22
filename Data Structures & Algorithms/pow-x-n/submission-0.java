class Solution {

    public double posPow(double x, int n){
        double ans = 1.0;

        while(n > 0){
            ans = ans*x;
            n--;
        }

        return ans;
    }

    public double negPow(double x, int n){
        double ans = 1.0;

        while(n > 0){
            ans = ans/x;
            n--;
        }
        return ans;
    }

    public double myPow(double x, int n) {
        if(n==0 || x == 1.00) return 1.00;
        if(x == -1.00){
            if(n%2 == 0) return 1.00;
            return -1.00;
        }

        if(n < 0){
            if(n == Integer.MIN_VALUE) return 0.00;
            n = n*(-1);
            return negPow(x, n);
        }

        return posPow(x, n);
    }
}