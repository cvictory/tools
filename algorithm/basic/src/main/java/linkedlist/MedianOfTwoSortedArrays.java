package linkedlist;

import java.math.BigDecimal;

/**
 * @author cvictory ON 2019-05-28
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if ((n1 + n2) % 2 == 0) {
            return (findElement(nums1, 0, n1 - 1, nums2, 0, n2 - 1, (n1 + n2) / 2) + findElement(nums1, 0, n1 - 1, nums2, 0, n2 - 1, (n1 + n2) / 2 + 1)) / 2.0;
        } else {
            return findElement(nums1, 0, n1 - 1, nums2, 0, n2 - 1, (n1 + n2 + 1) / 2);
        }
    }

    public double findElement(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int pos) {

        System.out.println(start1 + ", " + end1 + "," + start2 + ", " + end2 + ": " + pos);
        int length1 = end1 - start1 + 1, length2 = end2 - start2 + 1;
        if (length1 <= 0) {
            return nums2[start2 + pos - 1];
        } else if (length2 <= 0) {
            return nums1[start1 + pos - 1];
        }
        if (pos == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int lenght11 = Math.min(length1, (pos + 1) / 2), lenght22 = Math.min(length2, (pos + 1) / 2);
        System.out.println("--" + lenght11 + ", " + lenght22);
        if (nums1[start1 + lenght11 - 1] > nums2[start2 + lenght22 - 1]) {
            return findElement(nums1, start1, end1, nums2, start2 + lenght22, end2, pos - lenght22);
        } else if (nums1[start1 + lenght11 - 1] == nums2[start2 + lenght22 - 1]) {
            return nums1[start1 + lenght11 - 1];
        } else {
            return findElement(nums1, start1 + lenght11, end1, nums2, start2, end2, pos - lenght11);
        }
    }

    private BigDecimal calcMiddle(int[] nums1, int m1) {
        BigDecimal mid1 = null;
        if (nums1.length % 2 == 0) {
            mid1 = new BigDecimal(nums1[m1] + nums1[m1 - 1]).divide(new BigDecimal(2));
        } else {
            mid1 = new BigDecimal(nums1[m1]).divide(new BigDecimal(2));
        }
        return mid1;
    }

    private double calcMiddleD(int[] nums1) {
        int m1 = nums1.length / 2;
        double mid1 = 0;
        if (nums1.length % 2 == 0) {
            mid1 = (nums1[m1] + nums1[m1 - 1]) / 2;
        } else {
            mid1 = nums1[m1] / 2;
        }
        return mid1;
    }

    public static void main(String[] args) {
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
