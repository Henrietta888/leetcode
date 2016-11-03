package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/3.
 */
public class Solution409V1 {
    public int longestPalindrome(String s) {
        if (s == null) {
            return 0;
        } else if (s.length() < 2) {
            return 1;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character aChar = s.charAt(i);
            Integer count = map.get(aChar);
            if (count == null) {
                map.put(aChar, 1);
            } else {
                map.put(aChar, count + 1);
            }
        }
        int totalEvenLength = 0;

        int maxOddLength = 0;
        int totalOddCount = 0;
        int totalOddLength = 0;
        for (Integer integer : map.values()) {
            if (integer % 2 == 0) {
                totalEvenLength += integer;
            } else {
                maxOddLength = Math.max(maxOddLength, integer);
                totalOddCount++;
                totalOddLength += integer;
            }
        }
        int tmp = 0;
        if (totalOddLength > 0) {
            tmp = totalOddLength - totalOddCount + 1;
        }
        int result = totalEvenLength + tmp;
        return result;
    }

}
