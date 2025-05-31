// Approach
// Sort intervals by their end times to prioritize those that finish earliest.

// Start with the first interval and count it as non-overlapping.

// For each subsequent interval, if it starts after the previous interval's end, include it in the non-overlapping count and update the end time.

// The result is the total number of intervals minus the count of non-overlapping intervals.
// Example1 
// intervals = [[2, 3], [3, 4], [4, 5], [2, 4]]
// Output:1
// intervals = [[2, 3], [4, 5], [1, 7], [6, 8], [9, 10], [6, 10]]
// Output:2



class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] min_rolls = new int[n * n + 1];
        Arrays.fill(min_rolls, -1);
        Queue<Integer> q = new LinkedList<>();
        min_rolls[1] = 0;
        q.offer(1);

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 1; i <= 6 && x + i <= n * n; i++) {
                int t = x + i;
                int row = (t - 1) / n;
                int col = (t - 1) % n;
                int v = board[n - 1 - row][(row % 2 == 1) ? (n - 1 - col) : col];
                int y = (v > 0 ? v : t);
                if (y == n * n) return min_rolls[x] + 1;
                if (min_rolls[y] == -1) {
                    min_rolls[y] = min_rolls[x] + 1;
                    q.offer(y);
                }
            }
        }
        return -1;
    }
}
