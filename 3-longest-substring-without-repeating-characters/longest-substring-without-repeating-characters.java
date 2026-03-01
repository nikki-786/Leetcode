class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0, maxLen = 0;
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while(j != s.length()){
            char ch = s.charAt(j);
            if(!set.contains(ch)) {
                set.add(ch);
                len ++;
                maxLen = Math.max(maxLen , len);
                j++;
            } 
            else{
                set.remove(s.charAt(i));
                i++;
                len--;


            }
        }
        return Math.max(maxLen , len);
    }
}