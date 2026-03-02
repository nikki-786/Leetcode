class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> maps = new HashMap<>();
        Map<Character,Integer> mapt = new HashMap<>();
        if(s.length() != t.length()) return false;
        for(char ele : s.toCharArray()){
            maps.put(ele, maps.getOrDefault(ele , 0) + 1);
        }
        for(char ele : t.toCharArray()){
            mapt.put(ele, mapt.getOrDefault(ele , 0) + 1);
        }
        for(char ch : mapt.keySet()){
            if(!maps.containsKey(ch)) return false;
            else{
                if(!maps.get(ch).equals(mapt.get(ch)))return false;
            }
        }
        return true;
    }
}