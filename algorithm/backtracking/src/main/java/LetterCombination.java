import java.util.ArrayList;
import java.util.List;

/**
 * @author cvictory ON 2019-05-20
 */
public class LetterCombination {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        doCombination2(new StringBuilder(), combinations, digits);
        return combinations;
    }

    private void doCombination2(StringBuilder sb, List<String> combinations, String digits){
        if(sb.length() == digits.length()){
            combinations.add(sb.toString());
            return;
        }

        int pos = digits.charAt(sb.length()) - 'a';
        String cur = KEYS[pos];
        for(char c : cur.toCharArray()){
            sb.append(c);
            doCombination(sb, combinations, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    private void doCombination(StringBuilder sb, List<String> combinations, String digits) {

        if (sb.length() == digits.length()) {
            combinations.add(sb.toString());
            return;
        }

        int pos = digits.charAt(sb.length()) - '0';
        String key = KEYS[pos];

        for (char k : key.toCharArray()) {
            sb.append(k);
            doCombination(sb, combinations, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombination().letterCombinations("23"));
        System.out.println(new LetterCombination().letterCombinations("345"));
    }

}
