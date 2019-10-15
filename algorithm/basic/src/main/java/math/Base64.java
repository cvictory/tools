package math;

/**
 * @author cvictory ON 2019-07-23
 */
public class Base64 {

    public String toHex(int num) {
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        StringBuilder sb = new StringBuilder();
        while (num != 0){
            sb.append(map[num & 0b1111]);
            num = num >>> 4;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Base64().toHex(26));
        System.out.println(new Base64().toHex(-1));
    }
}
