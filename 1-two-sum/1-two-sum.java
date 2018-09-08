
/**
 *  use hash map
 */

import java.util.HashMap;
import java.util.Map;
import java.lang.*;

public class Solution{
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int component = target - nums[i];
            if (map.containsKey(component) && map.get(component) != i) {
                result[0] = Math.min(i,map.get(component));
                result[1] = Math.max(i,map.get(component));
                break;
            }
        }
        return result;
        //throw new IllegalArgumentException("No two sum solution");
    }
}