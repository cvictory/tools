import java.util.ArrayList;
import java.util.List;

/**
 * @author cvictory ON 2019-08-03
 */
public class RestoreIpAddresses2 {

    public List<String> restoreIpAddresses(String s) {
        List<String> r = new ArrayList<>();
        doRestoreIpAddresss(s, new StringBuilder(), r, 4);
        return r;
    }

    private void doRestoreIpAddresss(String s, StringBuilder sb, List<String> list, int length) {
        if (length == 0 || s.length() == 0) {
            if (length == 0 && s.length() == 0) {
                list.add(sb.toString());
                return;
            }
            return;
        }

        for (int i = 1; i <= 3 && i <= s.length(); i++) {
            String tmp = s.substring(0, i);
            if (Integer.parseInt(tmp) > 255) {
                continue;
            }
            int l = tmp.length();
            if (length != 4) {
                sb.append(".");
                l++;
            }
            sb.append(tmp);
            doRestoreIpAddresss(s.substring(i), sb, list, length - 1);
            sb.delete(sb.length() - l, sb.length());
        }
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIpAddresses2().restoreIpAddresses("25525511135"));
    }
}
