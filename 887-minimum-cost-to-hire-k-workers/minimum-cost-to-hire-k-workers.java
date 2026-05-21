class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;

        // worker = {ratio, quality}
        double[][] workers = new double[n][2];

        for (int i = 0; i < n; i++) {

            workers[i][0] = (double) wage[i] / quality[i];

            workers[i][1] = quality[i];
        }

        // Sort by ratio
        Arrays.sort(workers,(a, b) -> Double.compare(a[0], b[0]));

        // Max Heap for qualities
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int totalQuality = 0;

        double ans = Double.MAX_VALUE;

        for (double[] worker : workers) {

            int q = (int) worker[1];
            double ratio = worker[0];

            pq.add(q);

            totalQuality += q;

            // Keep only k workers
            if (pq.size() > k) {
                totalQuality -= pq.poll();
            }

            // Calculate minimum cost
            if (pq.size() == k) {

                ans = Math.min(ans,totalQuality * ratio);
            }
        }

        return ans;
    }
}