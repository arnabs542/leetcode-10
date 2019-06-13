package Array.Sorting;

/**
 *我们先用两个指针，一个指向已经排好序的0的序列的后一个点，
 * 一个指向已经排好序的2的序列的前一个点。这样在一开始，
 * 两个指针是指向头和尾的，因为我们还没有开始排序。
 * 然后我们遍历数组，当遇到0时，将其和0序列后面一个数交换，然后将0序列的指针向后移。
 * 当遇到2时，将其和2序列前面一个数交换，然后将2序列的指针向前移。
 * 遇到1时，不做处理。
 * 这样，当我们遍历到2序列开头时，实际上我们已经排好序了，因为所有0都被交换到了前面，所有2都被交换到了后面。
 */

public class SortColors {

    public void sortColorsWithTwoPass(int[] nums) {

        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                redCount++;
            }
            if (nums[i] == 1) {
                whiteCount++;
            }
            if (nums[i] == 2) {
                blueCount++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < redCount) {
                nums[i] = 0;
            } else if (i < redCount + blueCount) {
                nums[i] = 1;
            }
            else{
                nums[i] = 2;
            }
        }
    }

    public static void sortColors(int[] nums) {
        int redIndex = 0;
        int rightIndex = nums.length - 1;
        int index = 0;

        while (index <= rightIndex) {
            if (nums[index] == 0) {
                swap(nums, index, redIndex);
                index++;
                redIndex++;
            } else if (nums[index] == 1) {
                index++;
            } else if (nums[index] == 2) {
                swap(nums, index, rightIndex);
                rightIndex--;
            }
        }
    }

    private static void swap(int[] nums, int original, int destination) {
        int temp = nums[original];
        nums[original] = nums[destination];
        nums[destination] = temp;

    }
}