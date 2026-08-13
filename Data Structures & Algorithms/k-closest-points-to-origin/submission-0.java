class Solution {

    class Node{
        int distance;
        int x;
        int y;

        Node(int d, int x, int y){
            this.distance = d;
            this.x = x;
            this.y = y;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b) -> a.distance - b.distance);

        for(int[] point : points){
            int x = point[0];
            int y = point[1];

            int dist = (x * x) + (y * y);

            minHeap.offer(new Node(dist, x, y));
        }

        int i=0;
        int[][] result = new int[k][2];
        while(k>0 && !minHeap.isEmpty()){
            Node node = minHeap.poll();
            result[i][0] = node.x;
            result[i][1] = node.y;
            i++;
            k--;
        }

        return result;
    }
}
