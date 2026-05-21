class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];

        // Count frequency
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        boolean[] visited = new boolean[26];

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            freq[ch - 'a']--;

            // Skip if already added
            if (visited[ch - 'a']) {
                continue;
            }

            // Maintain lexicographical order
            while (!stack.isEmpty() &&
                   stack.peek() > ch &&
                   freq[stack.peek() - 'a'] > 0) {

                visited[stack.pop() - 'a'] = false;
            }

            stack.push(ch);

            visited[ch - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        for (char ch : stack) {
            ans.append(ch);
        }

        return ans.toString();
    }
}