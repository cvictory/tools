import java.util.ArrayList;
import java.util.List;

/**
 * @author cvictory ON 2019-05-20
 */
public class RestoreIpAddresses {
    /**
     * Given "25525511135",
     * return ["255.255.11.135", "255.255.111.35"].
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> addresses = new ArrayList<>();
        StringBuilder tempAddress = new StringBuilder();
        doSplit(0, addresses, tempAddress, s);
        return addresses;
    }

    private void doSplit(int k, List<String> addresses, StringBuilder tempAddress, String s) {
        if (k == 4 || s.length() == 0) {
            if (k == 4 && s.length() == 0) {
                addresses.add(tempAddress.toString());
            }
        }
        for (int i = 0; i <= 2 && i < s.length(); i++) {
            String prefix = s.substring(0, i + 1);
            if (Integer.parseInt(prefix) <= 255) {
                int sbLenght = tempAddress.length();
                if (k != 0) {
                    tempAddress.append(".");
                }
                tempAddress.append(prefix);
                String postfix = s.substring(i + 1);
                doSplit(k + 1, addresses, tempAddress, postfix);
                tempAddress.delete(sbLenght, tempAddress.length());
            }
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(new RestoreIpAddresses().restoreIpAddresses(s));
    }


    private void doBackTracking(List<String> r, String s, StringBuilder sb, int p){
        s.substring(p, 2);
    }
}
