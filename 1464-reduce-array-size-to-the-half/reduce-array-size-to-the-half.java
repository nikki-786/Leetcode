class Solution {
    public int minSetSize(int[] arr) {
        int count = 0;
        Map<Integer , Integer> freq = new HashMap<>();
        for(int ele : arr){
            freq.put(ele , freq.getOrDefault(ele , 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder((a,b) -> freq.get(a) - freq.get(b)));
        for(int ele : freq.keySet()){
            pq.offer(ele);
        }
        int temp = 0;
        while(!pq.isEmpty()){
            if(temp >= arr.length / 2){
                return count;
            }
            else{
                temp += freq.get(pq.poll());
                count++;
            }
        }
        return count;
    }
}