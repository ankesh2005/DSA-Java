public class ChampagneTower {
  // lc-799. Champagne Tower
  class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
      double[][] tower = new double[100][100];
      tower[0][0] = poured * 1.0;
      for (int i = 1; i <= query_row; i++) {
        for (int j = 0; j < i + 1; j++) {
          if (j == 0) {
            // only right parent exists
            tower[i][j] = Math.max(0, (tower[i - 1][j] - 1) / 2.0);
          } else if (j == i) {
            // only left parent exists
            tower[i][j] = Math.max(0, (tower[i - 1][j - 1] - 1) / 2.0);
          } else {
            double upleft = tower[i - 1][j - 1] - 1 > 0 ? (tower[i - 1][j - 1] - 1) / 2.0 : 0;
            double upright = tower[i - 1][j] - 1 > 0 ? (tower[i - 1][j] - 1) / 2.0 : 0;
            tower[i][j] = upleft + upright;
          }
        }
      }
      return Math.min(1, tower[query_row][query_glass]);

    }
  }
}
