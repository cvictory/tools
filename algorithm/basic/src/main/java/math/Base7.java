package math;

/**
 * @author cvictory ON 2019-07-23
 */
public class Base7 {

    public String convertToBase7(int num) {
        boolean negative = num > 0 ? false : true;
        if(negative){
            num = -num;
        }
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            int p = num % 7;
            num = num / 7;
            sb.append(p);
        }
        if(negative){
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Base7().convertToBase7(100));
        System.out.println(new Base7().convertToBase7(-7));
    }
}
