class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        int[] freq = new int[26];

        for(char i:s.toCharArray()) freq[i - 97]++;
        for(char i:t.toCharArray()) freq[i - 97]--;

        for(int count:freq){
            if(count>0) return false;
        }

        return true;
    }
}