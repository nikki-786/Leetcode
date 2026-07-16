class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : text.toCharArray()){
            if(ch == 'b' || ch == 'a' ||ch == 'l' ||ch == 'o' ||ch == 'n'){
                map.put(ch , map.getOrDefault(ch , 0 ) + 1);
            }
        }
        return Math.min(
                Math.min(map.getOrDefault('b', 0), map.getOrDefault('a', 0)),
                Math.min(
                        Math.min(map.getOrDefault('l', 0) / 2, map.getOrDefault('o', 0) / 2),
                        map.getOrDefault('n', 0)
                )
        );
    }
}