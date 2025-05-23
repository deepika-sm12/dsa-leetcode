class Solution {
    private static int run(int[] nums) {
        return -1;
    }

    private static void printArray(int[] nums) {
        System.out.print("[");
        for (int num : nums) {
            System.out.printf("%d, ", num);
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int result = run(nums);
        System.out.println("Result = " + result);
    }
}