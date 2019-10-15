package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author cvictory ON 2019-06-02
 */
public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        Arrays.fill(result, -1);
        for (int i = 1; ; i++) {
            if (stack.isEmpty()) {
                break;
            }
            while (stack != null && nums[stack.peek()] < nums[i % nums.length]) {
                int index = stack.pop();
                result[index] = nums[i % nums.length];
            }
            if (i < nums.length) {
                stack.push(nums[i % nums.length]);
            }
        }
        return result;
    }
}
