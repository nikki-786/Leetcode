class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        backtrack(ans,
                  new ArrayList<>(),
                  candidates,
                  target,
                  0);

        return ans;
    }

    private void backtrack(List<List<Integer>> ans,
                           List<Integer> path,
                           int[] candidates,
                           int target,
                           int index) {

        // Valid combination found
        if (target == 0) {

            ans.add(new ArrayList<>(path));

            return;
        }

        // Target exceeded
        if (target < 0) {
            return;
        }

        // Try all candidates from current index
        for (int i = index; i < candidates.length; i++) {

            // Choose current number
            path.add(candidates[i]);

            // Reuse allowed → i
            backtrack(ans,
                      path,
                      candidates,
                      target - candidates[i],
                      i);

            // Backtrack
            path.remove(path.size() - 1);
        }
    }
}