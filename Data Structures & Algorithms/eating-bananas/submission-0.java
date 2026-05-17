class Solution {

    public int hours(int[] piles, int mid){
        int ans = 0;
        for(int i=0; i<piles.length; i++){
            if(piles[i] <= mid){
                ans++;
            }
            else if(piles[i]%mid == 0){
                ans += piles[i]/mid;
            }
            else{
                ans += piles[i]/mid + 1;
            }
        }

        return ans;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int p: piles){
            high = Math.max(high, p);
        }
        int ans = 0;

        while(low <= high){
            int mid = low + (high-low)/2;

            int hrs = hours(piles, mid);

            if(hrs <= h){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return ans;
    }
}
