class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int count = 0;
        for(int ele : nums){
            if(ele <= pivot) count++;
        }
        int[] ans = new int[nums.length]; 
        int i = 0;
        Arrays.fill(ans,pivot);
        for(int j = 0 ; j < nums.length ; j++){
            if(nums[j] < pivot){
                ans[i++] = nums[j];
            }
            if(nums[j] > pivot){
                ans[count++] = nums[j];
            }
        }
        return ans;

        
    }
}