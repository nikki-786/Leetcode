
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
// The final array size equals nums.length (all elements go somewhere)
int[] result = new int[nums.length];
List<Integer> less = new ArrayList<>();
List<Integer> equal = new ArrayList<>();
List<Integer> greater = new ArrayList<>();
        for (int n : nums) {
    if (n < pivot) {
        less.add(n);
    } else if (n == pivot) {
        // ___ ?
        equal.add(n);
    } else {
        // ___ ?
        greater.add(n);
    }
}
// After categorization loop...

int idx = 0;

// Copy all three lists into result array
for (int val : less) {
    result[idx++] = val;
}

for (int val : equal) {
    result[idx++] = val;
}

for (int val : greater) {
    // ___ ?
    result[idx++] = val;
}

return result;
    }
}