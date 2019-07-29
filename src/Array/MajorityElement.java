package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 */


public class MajorityElement {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int ret = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            }
            else{
                map.put(num, map.get(num) + 1);
            }
            if (map.get(num) > nums.length / 2) {
                ret = num;
                break;
            }
        }
        return ret;
    }
}