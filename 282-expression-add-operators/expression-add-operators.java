class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();

        backtrack(ans, "", num, target, 0, 0, 0);

        return ans;
    }

    private void backtrack(List<String> ans, String path,
                           String num, int target,
                           int index, long value, long prev) {

        // If we used all digits
        if (index == num.length()) {

            // Check if expression evaluates to target
            if (value == target) {
                ans.add(path);
            }

            return;
        }

        // Try every possible number
        for (int i = index; i < num.length(); i++) {

            // Handle leading zero
            if (i != index && num.charAt(index) == '0') {
                break;
            }

            String currStr = num.substring(index, i + 1);

            long curr = Long.parseLong(currStr);

            // First number (no operator before it)
            if (index == 0) {

                backtrack(ans, currStr, num, target,
                          i + 1, curr, curr);

            } else {

                // Addition
                backtrack(ans,
                          path + "+" + currStr,
                          num,
                          target,
                          i + 1,
                          value + curr,
                          curr);

                // Subtraction
                backtrack(ans,
                          path + "-" + currStr,
                          num,
                          target,
                          i + 1,
                          value - curr,
                          -curr);

                // Multiplication
                backtrack(ans,
                          path + "*" + currStr,
                          num,
                          target,
                          i + 1,
                          value - prev + (prev * curr),
                          prev * curr);
            }
        }
    }
}