/**
 * @author cvictory ON 2019-04-16
 */
public class KthLargest {

    public static void main(String[] args) {
//        System.out.println(new KthLargest().findKthLargest(new int[]{6, 5, 7, 4, 1, 2}, 3));
//        System.out.println(new KthLargest().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
//        System.out.println(new KthLargest().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));

        System.out.println(new KthLargest().findKthLargest(new int[]{12, 9, 3, 7, 5, 8, 20, 18, 11}, 3));
        System.out.println(new KthLargest().findKthLargest(new int[]{12, 9, 3, 7, 5, 8, 20, 18, 11}, 5));
    }

    public int findKthLargest(int[] nums, int k) {
        int s = 0, end = nums.length - 1;
        k = end - k + 1;
        while (s < end) {
            int pos = divide(nums, s, end);
            System.out.println("==" + pos);
            if (pos == k) {
                return nums[pos];
            } else if (pos > k) {
                end = pos - 1;
            } else {
                s = pos + 1;
            }
        }
        return nums[k];
    }

    private int divide(int[] a, int l, int h) {
        int s = l, e = h + 1;
        while (s < e) {
            while (a[++s] < a[l] && s < h) ;
            while (a[--e] > a[l] && l < e) ;
            System.out.println(s + ":" + e);
            if (s >= e) {
                break;
            }
            swap(a, s, e);
        }
        swap(a, l, e);
        return e;
    }


    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
