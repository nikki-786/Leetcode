class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        backtrack(ans, new StringBuilder(), 0, 0, n);

        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder path, int open, int close, int n) {

        // Valid combination formed
        if (path.length() == 2 * n) {

            ans.add(path.toString());

            return;
        }

        // Add '('
        if (open < n) {

            path.append('(');

            backtrack(ans, path, open + 1, close, n);

            path.deleteCharAt(path.length() - 1);
        }

        // Add ')'
        if (close < open) {

            path.append(')');

            backtrack(ans, path, open, close + 1, n);

            path.deleteCharAt(path.length() - 1);
        }
    }
}