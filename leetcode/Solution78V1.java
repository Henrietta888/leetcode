package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/10/31.
 */
public class Solution78V1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //add empty array
        result.add(new ArrayList<>(0));
        //add unEmpty array
        for (int i = 1; i <= nums.length; i++) {
            result.addAll(subsetN(nums, i));
        }
        return result;
    }

    public List<List<Integer>> subsetN(int[] nums, int num) {
        List<List<Integer>> result = new ArrayList<>();
        if (num < 1 || num > nums.length) {
            return result;
        }
        if (num == 1) {
            for (int i = 0; i < nums.length; i++) {
                int num1 = nums[i];
                ArrayList<Integer> element = new ArrayList<>(1);
                element.add(num1);
                result.add(element);
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                int num1 = nums[i];
                List<List<Integer>> subsetN1 = subsetN(Arrays.copyOfRange(nums, i + 1, nums.length), num - 1);
                for (List<Integer> integers : subsetN1) {
                    ArrayList<Integer> element = new ArrayList<>(num);
                    //subset 1
                    element.add(num1);
                    // subset n-1
                    element.addAll(integers);
                    result.add(element);
                }
            }
        }
        return result;
    }
}
