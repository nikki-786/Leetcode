class Solution {
    public String reorganizeString(String s) {
        int n = s.length();

        // Count frequency of characters
        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        for (int count : freq.values()) {
            if (count > (n + 1) / 2) {
                return ""; // impossible to rearrange
            }
        }

        // Max Heap based on frequency
        PriorityQueue<Character> pq =
                new PriorityQueue<>(
                        (a, b) -> freq.get(b) - freq.get(a)
                );

        pq.addAll(freq.keySet());

        StringBuilder ans = new StringBuilder();

        // Store previous character temporarily
        Character prev = null;

        while (!pq.isEmpty()) {

            // Get character with highest frequency
            char curr = pq.poll();

            // Add current character
            ans.append(curr);

            // Reduce frequency
            freq.put(curr, freq.get(curr) - 1);

            // Add previous character back if still available
            if (prev != null && freq.get(prev) > 0) {
                pq.add(prev);
            }

            // Current character becomes previous
            prev = curr;
        }

        // Check if valid rearrangement was formed
        if (ans.length() != s.length()) {
            return "";
        }

        return ans.toString(); 
    }
}