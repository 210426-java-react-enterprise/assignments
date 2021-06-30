class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] mergedArray = new int[nums1.length + nums2.length];

        //edge cases where one array or other is empty
        if (mergedArray.length == 0) {
            return 0;
        } else if (nums1.length == 0) {
            return findMedian(nums2);
        } else if (nums2.length == 0) {
            return findMedian(nums1);
        }

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < mergedArray.length) {
            if(j == nums1.length) {
                mergedArray[i] = nums2[k++];
            } else if(k == nums2.length) {
                mergedArray[i] = nums1[j++];
            } else if(nums1[j] <= nums2[k]) {
                mergedArray[i] = nums1[j++];
            } else {
                mergedArray[i] = nums2[k++];
            }
            i++;
        }
        System.out.print("mergedArray[" + mergedArray.length + "]: { ");
        for (int l = 0; l < mergedArray.length; l++) {
            System.out.print(mergedArray[l] + " ");
        }
        System.out.println("}");
        return findMedian(mergedArray);
    }

    private double findMedian(int[] arr){
        double median = 0;
        int medianIndex = (arr.length - 1) / 2;
        if (arr.length % 2 == 1) {
            return arr[medianIndex];
        } else {

            return ((double)arr[medianIndex] + (double)arr[medianIndex + 1]) / 2;
        }
    }
}