class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String , Integer> freq = new HashMap<>();
        for(String str : words){
            freq.put(str , freq.getOrDefault(str ,0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a , b ) -> {
                if (freq.get(a).equals(freq.get(b))) {
                    return b.compareTo(a); // reverse lexicographical
                }
                return freq.get(a) - freq.get(b);
            });
        for(String i : freq.keySet()){
            pq.add(i);
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<String> list = new ArrayList<>();
         while (!pq.isEmpty()) {
            list.add(pq.poll());
        }

        // Reverse to get correct order
        Collections.reverse(list);
        return list;
    }
}