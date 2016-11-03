package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Administrator on 2016/11/1.
 */
public class Solution392V1 {
    public boolean isSubsequence(String s, String t) {
        if (s == null||s.length()<1) {
            return true;
        }
        if (s == t || s.equals(t)) {
            return true;
        }
        Queue<Character> sq = new ArrayDeque<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            sq.add(s.charAt(i));
        }
        Character target = sq.poll();

        for (int i = 0; i < t.length(); i++) {
            if (target.equals(t.charAt(i))) {
                if ((target = sq.poll()) == null) {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        String s = "", t = "abcade";
        System.out.println((new Solution392V1()).isSubsequence(s, t));
    }
}
