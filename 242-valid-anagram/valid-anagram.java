class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        int[] freq = new int[128];

        for(char i:s.toCharArray()) freq[i]++;
        for(char i:t.toCharArray()) freq[i]--;

        for(int count:freq){
            if(count>0) return false;
        }

        return true;
    }
}