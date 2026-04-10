class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int minSum = Integer.MAX_VALUE;
        boolean find = false;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                int sum = 0;
                for(int k = j + 1 ; k < n ; k++){
                    if(nums[i] == nums[j] && nums[j]== nums[k]){
                        sum = (j - i) +(k - j) +(k - i);
                        minSum = Math.min(sum , minSum);
                        find = true;
                    }
                }
            }
        }
        if(!find) return -1;
        return minSum;
    }
}