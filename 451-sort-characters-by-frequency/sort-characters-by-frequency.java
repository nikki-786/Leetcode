class Solution {
    public String frequencySort(String s) {
        Map<Character , Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0) + 1);
        }
        StringBuilder str = new StringBuilder();
        PriorityQueue<Map.Entry<Character , Integer>> pq =new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        while(!pq.isEmpty()){
            Map.Entry<Character , Integer > value = pq.poll();
            char ch = value.getKey();
            int val = value.getValue();
            for(int i = 0 ; i < val ; i++){
                str.append(ch);
            }
        }
        return str.toString();
        
    }
}