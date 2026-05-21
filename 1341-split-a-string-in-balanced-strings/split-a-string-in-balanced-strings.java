class Solution {
    public int balancedStringSplit(String s) {
        int balancer = 0;
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'R'){
                balancer++;
            }
            else{
                balancer--;
            }
            if(balancer == 0){
                count++;
            }
        }
        return count;
    }
}