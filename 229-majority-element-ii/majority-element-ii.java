class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+ 1);
        }
        for(int ele : map.keySet()){
            if(map.get(ele) > (nums.length /3)){
                ans.add(ele);
            }
        }
        return ans;
    }
}