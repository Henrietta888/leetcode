package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Administrator on 2016/11/2.
 */
public class Solution130V1 {
    public static final char X = 'X';
    public static final char O = 'O';
    public static final char F = 'F';
    private Queue<Point> q = new ArrayDeque<>();
    class Point {
        protected int x;
        protected int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length < 3 || board[0].length < 3) {
            return;
        }

        //flag
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
                    if (aChar == O) {
                        chars[j] = F;
                        q.add(new Point(i, j));
                    }
                }
            }
        }

        //handle
        while (q.size() > 0) {
            Point point = q.poll();
            int x = point.x, y = point.y;
            //top
            handleElement(board, x - 1, y);
            //right
            handleElement(board, x, y + 1);
            //bottom
            handleElement(board, x + 1, y);
            //left
            handleElement(board, x, y - 1);
        }

        //flag back
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                if (aChar == O) {
                    chars[j] = X;
                } else if (aChar == F) {
                    chars[j] = O;
                }

            }
        }

    }

    private void handleElement(char[][] board, int x, int y) {
        if (x > -1 && y > -1 && x < board.length && y < board[0].length) {
            char aChar = board[x][y];
            if(aChar==O){
                board[x][y]=F;
                q.add(new Point(x, y));
            }
        }
    }
}
