class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num , freq.getOrDefault(num , 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> freq.get(a) - freq.get(b));
        for(int ele : freq.keySet()){
            pq.add(ele);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int i = 0;
        while(!pq.isEmpty()){
            ans[i++] = pq.poll();
        }
        return ans;

        
    }
}