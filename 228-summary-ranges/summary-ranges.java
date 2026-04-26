class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return list;
        int s = nums[0];
        for(int i = 1 ; i < n ; i++){
            if(nums[i - 1] + 1 != nums[i]) {
                if(s == nums[i - 1]) list.add(String.valueOf(s));
                else {
                    list.add(s + "->" + nums[i - 1]);
                }
                s = nums[i];
            }
        }
        if(s == nums[n - 1]) list.add(String.valueOf(s));
                else {
                    list.add(s + "->" + nums[n - 1]);
                }
        return list;
    }
}