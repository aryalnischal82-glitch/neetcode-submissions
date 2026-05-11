class Solution {
    public int maxProfit(int[] prices) {
     int l=0;
     int currProfit=0;
     int maxProfit=0;
     for(int r=1;r<prices.length;r++){
        while(l<r && prices[r]<prices[l]) l++;
        currProfit=prices[r]-prices[l];
        maxProfit=Math.max(currProfit,maxProfit);
     }
     return maxProfit;   
    }
}
