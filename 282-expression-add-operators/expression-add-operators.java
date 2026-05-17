
class Solution {

    public List<String> addOperators(String num, int target) {

        List<String> ans = new ArrayList<>();

        backtrack(ans,
                  new StringBuilder(),
                  num,
                  target,
                  0,
                  0,
                  0);

        return ans;
    }

    private void backtrack(List<String> ans,
                           StringBuilder path,
                           String num,
                           int target,
                           int index,
                           long value,
                           long prev) {

        // If all digits are used
        if (index == num.length()) {

            // Check if expression equals target
            if (value == target) {
                ans.add(path.toString());
            }

            return;
        }

        // Try every possible number
        for (int i = index; i < num.length(); i++) {

            // Prevent leading zeros
            if (i != index && num.charAt(index) == '0') {
                break;
            }

            String currStr = num.substring(index, i + 1);

            long curr = Long.parseLong(currStr);

            int len = path.length();

            // First number
            if (index == 0) {

                path.append(currStr);

                backtrack(ans,
                          path,
                          num,
                          target,
                          i + 1,
                          curr,
                          curr);

                path.setLength(len);

            } else {

                // Addition
                path.append('+').append(currStr);

                backtrack(ans,
                          path,
                          num,
                          target,
                          i + 1,
                          value + curr,
                          curr);

                path.setLength(len);

                // Subtraction
                path.append('-').append(currStr);

                backtrack(ans,
                          path,
                          num,
                          target,
                          i + 1,
                          value - curr,
                          -curr);

                path.setLength(len);

                // Multiplication
                path.append('*').append(currStr);

                backtrack(ans,
                          path,
                          num,
                          target,
                          i + 1,
                          value - prev + prev * curr,
                          prev * curr);

                path.setLength(len);
            }
        }
    }
}