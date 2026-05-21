class Solution {
    public int findContentChildren(int[] g, int[] s) {
         // Sort greed factors
        Arrays.sort(g);

        // Sort cookie sizes
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;

        // Match cookies with children
        while (child < g.length && cookie < s.length) {

            // Cookie satisfies child
            if (s[cookie] >= g[child]) {
                child++;
            }

            // Move to next cookie
            cookie++;
        }

        return child;
    }
}