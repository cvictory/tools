package math;

/**
 * @author cvictory ON 2019-07-27
 */
public class IsNumber {

    public boolean isNumeric(char[] str) {
        String r = new String(str);
        return r.matches("[+-]?\\d+(.\\d*)([Ee][+-]?\\d+)?");
    }
}
