class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;

        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {

            totalGas += gas[i];
            totalCost += cost[i];

            tank += gas[i] - cost[i];

            // Cannot reach next station
            if (tank < 0) {

                // Next station becomes new start
                start = i + 1;

                // Reset tank
                tank = 0;
            }
        }

        // If total gas is insufficient
        if (totalGas < totalCost) {
            return -1;
        }

        return start;
    }
}