class Twitter {
    Map<Integer,Set<Integer>> followMap;
    Map<Integer,List<Tweet>> tweetMap;
    int count;
    public Twitter() {
        this.followMap=new HashMap<>();
        this.tweetMap=new HashMap<>();
        this.count=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId,new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(++count,tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq=new PriorityQueue<>((a,b)->Integer.compare(b.timestamp,a.timestamp));
        //own tweets
        if(tweetMap.containsKey(userId)){
            int size=tweetMap.get(userId).size();
            for(int i=size-1;i>=0 && i>=size-10;i--){
                pq.offer(tweetMap.get(userId).get(i));
            }
        }
      

        if(followMap.containsKey(userId)){
            Set<Integer> followees=followMap.get(userId);
            for(int followee: followees){
                int size=tweetMap.get(followee).size();
                for(int i=size-1;i>=0 && i>=size-10;i--){
                    pq.offer(tweetMap.get(followee).get(i));
                }
            }
        }
   

        List<Integer> res=new ArrayList<>();
        for(int i=0;i<10;i++){
            if(!pq.isEmpty()) res.add(pq.poll().tweetId);
        }
        return res;

        
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId) return;
        followMap.putIfAbsent(followerId,new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId) return;
        if(followMap.containsKey(followerId) && followMap.get(followerId).contains(followeeId)){
            followMap.get(followerId).remove(followeeId);
        }        
    }
}

class Tweet{
    int timestamp;
    int tweetId;

    public Tweet(int timestamp, int tweetId){
        this.timestamp=timestamp;
        this.tweetId=tweetId;
    }
}
