public class Driver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] testArray1 = new int[] {1, 2};
        int[] testArray2 = new int[] {3, 4};


        double result = solution.findMedianSortedArrays(testArray1, testArray2);
        System.out.println("Result: " + result);
    }



}
