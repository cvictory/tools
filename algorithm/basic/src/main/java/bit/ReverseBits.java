package bit;

/**
 * @author cvictory ON 2019-07-26
 */
public class ReverseBits {

    public int reverseBits(int n) {
        int r = 0;
        while (n != 0) {
            r = (r << 1);
            if ((n & 1) == 1) {
                r |= 1;
            }
            n = n >>> 1;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(43261596));
        System.out.println(new ReverseBits().reverseBits(-3));
    }
}
