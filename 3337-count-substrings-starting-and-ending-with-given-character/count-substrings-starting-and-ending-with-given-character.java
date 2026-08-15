class Solution {
    public long countSubstrings(String s, char c) {
        long count = 0;
        long subCount = 0;
        for(char ch : s.toCharArray()){
            if(ch == c){
                count++;
                subCount += count;
            }
        }
        return subCount;
    }
}