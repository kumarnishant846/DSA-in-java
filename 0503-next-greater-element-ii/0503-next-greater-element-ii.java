class Solution {
public int[] nextGreaterElements(int[] nums) {
int n = nums.length;
int[] result = new int[n];
Stack<Integer> stack = new Stack<>();


    Arrays.fill(result, -1);

    for (int i = 2 * n - 1; i >= 0; i--) {
        int index = i % n;

        while (!stack.isEmpty() && stack.peek() <= nums[index]) {
            stack.pop();
        }

        if (i < n && !stack.isEmpty()) {
            result[index] = stack.peek();
        }

        stack.push(nums[index]);
    }

    return result;
}


}
