class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();

        backtrack(ans, "", num, target, 0, 0, 0);

        return ans;
    }

    private void backtrack(List<String> ans,
                           String path,
                           String num,
                           int target,
                           int index,
                           long value,
                           long prev) {

        // If all digits are used
        if (index == num.length()) {

            // Check if expression equals target
            if (value == target) {
                ans.add(path);
            }

            return;
        }

        // Try every possible number from current index
        for (int i = index; i < num.length(); i++) {

            // Prevent numbers with leading zeros
            if (i != index && num.charAt(index) == '0') {
                break;
            }

            String currStr = num.substring(index, i + 1);

            long curr = Long.parseLong(currStr);

            // First number in expression
            // No operator needed before it
            if (index == 0) {

                backtrack(ans,
                          currStr,
                          num,
                          target,
                          i + 1,
                          curr,
                          curr);

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
                // Remove previous operand and replace it
                // with prev * curr to handle precedence
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