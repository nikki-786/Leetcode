class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            // Adjust for 1-based indexing (A=1 becomes 0)
            columnNumber--; 
            
            // Get the current character (0 -> 'A', 25 -> 'Z')
            char currentChar = (char) ('A' + (columnNumber % 26));
            sb.append(currentChar);
            
            // Move to the next "digit" position
            columnNumber /= 26;
        }
        
        // Reverse because characters were added from right to left
        return sb.reverse().toString();
    }
}