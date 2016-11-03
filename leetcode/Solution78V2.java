package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/31.
 */
public class Solution78V2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<String> indexSets = getIndexSets(nums.length);
        List<List<Integer>> result = doSubsets(nums, indexSets);
        return result;
    }

    private List<List<Integer>> doSubsets(int[] nums, List<String> indexSets) {
        List<List<Integer>> ll = new ArrayList<>(indexSets.size());
        for (String indexSet : indexSets) {
            List<Integer> list = new ArrayList<Integer>(nums.length);
            for (int i = 0; i < indexSet.length(); i++) {
                if (indexSet.charAt(i) == '1') {
                    list.add(nums[i]);
                }
            }
            ll.add(list);
        }

        return ll;
    }

    private List<String> getIndexSets(int length) {
        if (length > 32) {
            throw new IllegalArgumentException("Not support the length which bigger than 32");
        }
        List<String> list = new ArrayList<String>();
        int m = (int) Math.pow(2, length);
        for (int i = 0; i < m; i++) {
            String binaryStr = Integer.toBinaryString(i);
            if (binaryStr.length() < length) {
                StringBuilder sb = new StringBuilder(binaryStr);
                int i1 = length - binaryStr.length();
                for (int j = 0; j < i1; j++) {
                    sb.insert(0, "0");
                }
                binaryStr = sb.toString();
            }
            list.add(binaryStr);
        }
        return list;
    }

}
