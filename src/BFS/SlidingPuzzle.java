package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/**
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.
 * <p>
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 * <p>
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 * <p>
 * Given a puzzle board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.
 * <p>
 * Examples:
 * <p>
 * Input: board = [[1,2,3],[4,0,5]]
 * Output: 1
 * Explanation: Swap the 0 and the 5 in one move.
 * Input: board = [[1,2,3],[5,4,0]]
 * Output: -1
 * Explanation: No number of moves will make the board solved.
 * Input: board = [[4,1,2],[5,0,3]]
 * Output: 5
 * Explanation: 5 is the smallest number of moves that solves the board.
 * An example path:
 * After move 0: [[4,1,2],[5,0,3]]
 * After move 1: [[4,1,2],[0,5,3]]
 * After move 2: [[0,1,2],[4,5,3]]
 * After move 3: [[1,0,2],[4,5,3]]
 * After move 4: [[1,2,0],[4,5,3]]
 * After move 5: [[1,2,3],[4,5,0]]
 * Input: board = [[3,2,4],[1,5,0]]
 * Output: 14
 * Note:
 * <p>
 * board will be a 2 x 3 array as described above.
 * board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].
 */

// 把二维数组转换为一维的， 这样好比较。同时关键点是要把所有0在的positions的可能移动的方位先列明出来。
// 然后就是正常的BFS了
// 把 [[4,1,2],[5,0,3]] , 看成是 4 1 2 5 0 3, 然后利用找出 0 的位置，再从dir里面找出相应可以走的direction 放到queue里面
// 同时还要自己写一个swap方法去得到新的 string
public class SlidingPuzzle {

    public int slidingPuzzle(int[][] board) {

        String target = "123450";
        String start = "";

        // 转换为一维的
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start += board[i][j];
            }
        }

        Set<String> visited = new HashSet();

        // 0 1 2
        // 3 4 5
        // 第一个dir表示若0在index 0，时候可以走的位置， 第二个dir表示若0在index 1，时候可以走的三个位置
        int[][] dir = new int[][]{
                {1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}
        };

        Queue<String> queue = new LinkedList();
        queue.offer(start);
        visited.add(start);
        int count = 0;

        while (!queue.isEmpty()) {

            // count how many node in current level
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return count;
                }

                int zeroIndex = cur.indexOf("0");

                for (int direction : dir[zeroIndex]) {
                    String next = swap(cur, zeroIndex, direction);
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    queue.offer(next);
                }

            }
            count++;
        }
        return count;
    }

    public String swap(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(j, s.charAt(i));
        sb.setCharAt(i, s.charAt(j));
        return sb.toString();
    }
}
