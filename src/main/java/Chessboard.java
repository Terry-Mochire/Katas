import java.util.LinkedList;

//Given a chessboard, find the minimum number of moves required to move a knight from the parameter given as src to the destination given as dest.
//The chessboard is a 8x8 grid. The knight can move to any of the 8 positions that are 2 squares away horizontally and 1 square vertically, or 2 squares vertically and 1 square horizontally away from its current position. The knight cannot move off the board.
public class Chessboard {
    public static void main(String[] args) {
        System.out.println(solution(19,28));
        System.out.println(solution(0,1));
    }

    private static int solution(int src, int dest) {
        int[] moves = new int[64];
        boolean[] visited = new boolean[64];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == dest) {
                return moves[current];
            }
            for (int i = 0; i < 8; i++) {
                int next = getNext(current, i);
                if (next != -1 && !visited[next]) {
                    visited[next] = true;
                    moves[next] = moves[current] + 1;
                    queue.add(next);
                }
            }
        }
        return -1;

    }

    private static int getNext(int current, int i) {
        int[] row = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] col = {1, -1, 1, -1, 2, -2, 2, -2};
        int nextRow = current / 8 + row[i];
        int nextCol = current % 8 + col[i];
        if (nextRow >= 0 && nextRow < 8 && nextCol >= 0 && nextCol < 8) {
            return nextRow * 8 + nextCol;
        }
        return -1;
    }


}
