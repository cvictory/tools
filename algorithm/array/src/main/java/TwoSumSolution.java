import java.util.Arrays;

/**
 * @author cvictory ON 2019-04-16
 */
public class TwoSumSolution {

    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int[] result = new int[2];
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            }
            if (numbers[start] + numbers[end] > target) {
                end--;
            }
            if (numbers[start] + numbers[end] < target) {
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i : twoSum(new int[]{2, 7, 11, 15}, 13)) {
            System.out.println(i);
        }
    }
}
