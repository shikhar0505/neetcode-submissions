class Solution {
    public int maxProduct(int[] nums) {
        /*
        Prefix:
        At every index, left -> right, get a rolling product of product so far.
        Also keep a maxProduct.

        Suffix:
        At every index, right -> left, get a rolling product of product so far.
        Also update the maxProduct.

        If we see 0, then it means a new sub-array is starting.
        */

        int n = nums.length;
        int res = nums[0];
        int prefix = 0, suffix = 0;

        for (int i = 0; i < n; i++) {
            prefix = nums[i] * (prefix == 0 ? 1 : prefix);
            res = Math.max(res, prefix);
        }

        for (int i = n - 1; i >= 0; i--) {
            suffix = nums[i] * (suffix == 0 ? 1 : suffix);
            res = Math.max(res, suffix);
        }

        return res;
    }
}
