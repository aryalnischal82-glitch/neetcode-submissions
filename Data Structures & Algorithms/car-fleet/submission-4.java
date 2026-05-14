class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int l=position.length;
        int[][] cars=new int[l][2];
        for(int i=0;i<l;i++){
            cars[i][0]=position[i];
            cars[i][1]=speed[i];
        }
        Arrays.sort(cars,(a,b)->a[0]-b[0]);
        double lastCarTime=(target-cars[l-1][0])/cars[l-1][1];
        int fleets=1;
        for(int i=l-2;i>=0;i--){
            double currCarTime=(double)(target-cars[i][0])/cars[i][1];
            System.out.println(currCarTime);
            System.out.println(lastCarTime);
            if(currCarTime>lastCarTime){
                System.out.println("I am here");
                fleets++;
                lastCarTime=currCarTime;
            }
        }
        return fleets;
    }
}
