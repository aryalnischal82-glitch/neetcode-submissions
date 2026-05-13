class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque=new ArrayDeque<>();
        //deque<[idx], elem can be derived from idx
        int l=nums.length;
        int[] res=new int[l-k+1];
        int resIdx=0;
        for(int r=0;r<l;r++){
            while(!deque.isEmpty() && deque.peekFirst()<=r-k){
                deque.removeFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[r]){
                deque.removeLast();
            }
            deque.addLast(r);
            if(r<k-1) continue;
            res[resIdx++]=nums[deque.peekFirst()];
        }
        return res;
    }
}
