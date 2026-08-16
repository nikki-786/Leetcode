class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];
        for (int stone : stones) {
            count[stone % 3]++;
        }
        
        // If the number of '3-divisible' stones is even, they don't change the outcome parity.
        if (count[0] % 2 == 0) {
            // Alice wins if both type-1 and type-2 stones exist.
            // If one type is completely missing, she cannot make a winning forced sequence.
            return count[1] > 0 && count[2] > 0;
        }
        
        // If the number of '3-divisible' stones is odd, it flips the turn parity.
        // Alice wins if the count difference between type-1 and type-2 stones is strictly greater than 2.
        return Math.abs(count[1] - count[2]) > 2;
    }
}