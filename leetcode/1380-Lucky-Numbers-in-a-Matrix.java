
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int minCol = 0;

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < matrix[i][minCol]) {
                    minCol = j;
                }
            }

            int val = matrix[i][minCol];
            boolean isMax = true;

            for (int r = 0; r < m; r++) {
                if (matrix[r][minCol] > val) {
                    isMax = false;
                    break;
                }
            }

            if (isMax) {
                res.add(val);
            }
        }

        return res;
    }
}
