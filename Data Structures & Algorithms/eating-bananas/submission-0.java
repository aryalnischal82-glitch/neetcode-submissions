class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // if(piles.length>h) return -1;
        int l=1;
        int max=0;
        for(int pile: piles) max=Math.max(max,pile);
        int r=max;
        int res=Integer.MAX_VALUE;
        while(l<=r){
            int mid=l+(r-l)/2;
            boolean canEat=canEat(mid,piles,h);
            if(canEat){
                r=mid-1;
                res=Math.min(res,mid);
            }else{
                l=mid+1;
            }

        }
        return res;
    }

    private boolean canEat(int speed, int[] piles, int h){
        int totalHours=0;
        for(int pile: piles){
           totalHours+=Math.ceil((double)pile/speed);
        }
        if(totalHours<=h){
            return true;
        }else{
            return false;
        }
    }
}
