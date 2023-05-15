import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private class Pos {
        int row, col;

        Pos() {
            row = 0;
            col = 0;
        }
        Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    } // end of Position

    int bfs (Pos start, int m, int n, int[][] picture, int[][] visit, int color) {
        Queue<Pos> q = new LinkedList<>();
        int n_connect = 0;

        q.add(start);


        while (q.isEmpty() == false) {

            Pos currentPos = q.poll();

            if (visit[currentPos.row][currentPos.col] != 0) {
                continue;
            }

            visit[currentPos.row][currentPos.col] = color;
            n_connect++;

            int[] dy = {-1, 1, 0, 0};
            int[] dx = {0, 0, -1, 1};

            for (int i = 0; i < 4; i++) {
                int row = currentPos.row + dy[i];
                int col = currentPos.col + dx[i];

                if (row < 0 || col < 0 || row >= m || col >= n) {
                    continue;
                }

                if (picture[row][col] == color && visit[row][col] ==0) {
                    q.add(new Pos(row, col));
                }
            }
        }
        return n_connect;
    } // end of bfs

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[][] visit = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (picture[row][col] != 0 && visit[row][col] == 0) {
                    int area = bfs(new Pos(row, col), m, n, picture, visit, picture[row][col]);

                    if (area > maxSizeOfOneArea) {
                        maxSizeOfOneArea = area;
                    }
                    numberOfArea++;
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    } // end of Solution
}

public class Test {
    public static void main(String[] args) {
        Solution bfs = new Solution();

        int m = 6;
        int n = 4;

        int [][] picture = {
                {1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1},
                {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}
        };

        System.out.println(Arrays.toString(bfs.solution(m, n, picture)));
    }
}