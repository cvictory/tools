import java.util.ArrayList;
import java.util.List;

/**
 * @author cvictory ON 2019-04-25
 */
public class DiffWaysToCompute {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char t = input.charAt(i);
            if (t == '+' || t == '-' || t == '*') {
                String left = input.substring(0, i);
                String right = input.substring(i + 1, input.length());
//                System.out.println(left + " -- " + right);
                List<Integer> leftArrays = diffWaysToCompute(left);
                List<Integer> rightArrays = diffWaysToCompute(right);
//                System.out.println("***" + leftArrays + ", " + rightArrays + ", " + ways + ", " + input + ", " + i);
                for (Integer l : leftArrays) {
                    for (Integer r : rightArrays) {
//                        System.out.println("inner : " + l + ";" + r + " ;" + t + "..ways: " + ways);
                        switch (t) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
//        System.out.println("r : " +ways);
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(new DiffWaysToCompute().diffWaysToCompute("2-1-1"));
        System.out.println(new DiffWaysToCompute().diffWaysToCompute("2*3-4*5"));
    }
}
