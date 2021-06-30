import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        ArrayList<Integer> mergedArray = new ArrayList<>();

        int mid;
        double median;
//        int i = 0;
//        int j = 0;
//
//        while ((i < nums1.length) && (j < nums2.length)) {
//            if (nums1[i] < nums2[j]) {
//                mergedArray.add(nums1[i]);
//                i++;
//            } else {
//                mergedArray.add(nums2[j]);
//                j++;
//            }
//        }
//
//        if (i == nums1.length) {
//            while (j < nums2.length) {
//                mergedArray.add(nums2[j]);
//                j++;
//            }
//        } else {
//            while (i < nums1.length) {
//                mergedArray.add(nums1[i]);
//                i++;
//            }
//        }

        for (int num: nums1) {
            mergedArray.add(num);
        }
        for (int num: nums2) {
            mergedArray.add(num);
        }

        Collections.sort(mergedArray);

        mid  = mergedArray.size() / 2;

        if (mergedArray.size() % 2 == 0) {
            median = (double)(mergedArray.get(mid) + mergedArray.get(mid - 1)) / 2;
        } else {
            median = mergedArray.get(mid);
        }

        return median;
    }
}