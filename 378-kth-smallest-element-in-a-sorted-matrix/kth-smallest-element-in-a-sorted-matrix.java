class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int row = 0 ; row < matrix.length ; row++){
            for(int col = 0 ; col < matrix[0].length ; col++){
                pq.offer(matrix[row][col]);
                if(pq.size() > k){
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}