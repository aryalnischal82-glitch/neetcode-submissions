class Solution {
    public int maxProfit(int[] prices) {
        int minPriceSoFar=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int r=1;r<prices.length;r++){
            minPriceSoFar=Math.min(minPriceSoFar,prices[r-1]);
            maxProfit=Math.max(maxProfit,prices[r]-minPriceSoFar);
        }
        return maxProfit;
    }
}

//Better to use greedy programming here 
