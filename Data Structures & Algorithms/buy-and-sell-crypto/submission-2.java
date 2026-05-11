class Solution {
    public int maxProfit(int[] prices) {
     int l=0;
     int currProfit=0;
     int maxProfit=0;
     int r=1;
     while(r<prices.length){
        while(l<r && prices[r]<prices[l]){
            l++;
        }
        currProfit=prices[r]-prices[l];
        maxProfit=Math.max(currProfit,maxProfit);
        r++;
     }
     return maxProfit;   
    }
}
