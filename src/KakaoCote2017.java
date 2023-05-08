import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class KakaoCote2017Solution {

    private class Pos { // 큐에 넣을 구조체
        int row, col;

        // 생성자
        Pos() { // 기본생성자
            row = 0;
            col = 0;
        }
        Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    } // end of Position

    // 탐색 bfs를 구현. 시작 위치를 인자로 받고, 몇개가 연결되었는지 리턴한다
    // 배열 picture의 length로 행열 개수를 알수있지만, 귀찮으니까 이미 주어진 m과 n을 사용한다
    // color : 이 픽셀의 색깔
    int bfs (Pos start, int m, int n, int[][] picture, int[][] visit, int color) {
        Queue<Pos> q = new LinkedList<>(); // java의 Queue는 abstract 라서 바로 사용할 수 없다

        // 연결된 노드(픽셀)의 개수
        int n_connect = 0;

        // 넣을때(push)는 add, 뺄때(pop)는 poll 하면 됨
        q.add(start); // 큐에 시작위치(루트)를 넣고, 큐가 빌 때 까지 큐에서 빼면서 처리한다


        while (q.isEmpty() == false) { // 큐가 비어있지 않으면 탐색 시작
            // 큐에서 하나 뺀다
            Pos currentPos = q.poll(); // 가장 마지막 큐를 pop 함

            // 중복 예외처리 -> 이미 방문했던 노드면(0이 아니면) pass
            if (visit[currentPos.row][currentPos.col] != 0) {
                continue; // 밑에 어떠한 코드가 있어도 while문 처음으로 돌아감
            }

            // 처음 방문한 노드면 방문표시 -> 픽셀의 color
            visit[currentPos.row][currentPos.col] = color;
            n_connect++; // 연결된 노드의 개수 +1해줌

            // 연결된 것이 있으면 큐에 넣는다. {상, 하, 좌, 우} 순서
            // 상하좌우 순서로 방문. 행과 열에서 각 좌표를 더하고 뺌으로써 상하 / 좌우 움직였다
            int[] dy = {-1, 1, 0, 0};
            int[] dx = {0, 0, -1, 1};

            // 연결된 4 방향을 체크. 아 그림그려서 + 인덱스 생각하면 좀 이해감
            for (int i = 0; i < 4; i++) {
                // 이웃  노드의 row, col 을 계산
                int row = currentPos.row + dy[i];
                int col = currentPos.col + dx[i];

                // 예외처리 : 상하좌우 방향에 대해 m * n을 벗어나는거면 while문 첫줄로 돌아간다
                if (row < 0 || col < 0 || row >= m || col >= n) {
                    continue;
                }

                // 이웃노드의 색깔이 같으면 연결되어 있는 것
                // picture 배열의 row와 col은 이웃의 것. 그림을 봤을 때, 이웃이 나와 색이 같으면
                // 그리고 방문하지 않았은 이웃이면
                if (picture[row][col] == color && visit[row][col] ==0) {
                    q.add(new Pos(row, col));
                }
            }
        }
        return n_connect; // 연결되어있는 노드(픽셀) 수를 리턴
    } // end of bfs

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[][] visit = new int[m][n]; // 방문한 노드를 집어넣을 곳

        // 모든 픽셀을 탐색하게 함 -> m * n
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                // 0이 아니고, 방문한 적 없으면 루트노드가 됨
                if (picture[row][col] != 0 && visit[row][col] == 0) {
//                    System.out.println("start BFS from (" + row + ", " + col + ")");
                    int area = bfs(new Pos(row, col), m, n, picture, visit, picture[row][col]);
                    // bfs(Pos start, int m, int n, int[][] picture, int[][] visit, int color)
                    System.out.println("면적은 " + area + "입니다");

                    // 면적이 가장 큰 면적보다 크면
                    if (area > maxSizeOfOneArea) {
                        maxSizeOfOneArea = area; // 가장 큰 면적 업데이트
                    }
                    numberOfArea++; // 영역의 갯수 추가됨
                }
            }
        }
        System.out.println("영역 : " + numberOfArea);
        System.out.println("가장 큰 면적 : " + maxSizeOfOneArea);
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    } // end of Solution
}

public class KakaoCote2017 {
    public static void main(String[] args) {
        KakaoCote2017Solution bfs = new KakaoCote2017Solution();

        int m = 6;
        int n = 4;

        int [][] picture = {
            {1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1},
            {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}
        };

        System.out.println(Arrays.toString(bfs.solution(m, n, picture)));
    }
}