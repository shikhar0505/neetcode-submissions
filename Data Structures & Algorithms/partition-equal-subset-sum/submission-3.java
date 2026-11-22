class Solution {
    public boolean canPartition(int[] nums) {
        /*
        Intuition:
        - if sum is odd, return false, not possible
        - start at last
        - add number of sums we can create using this element into a set
        - repeat for everyone
        */
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        Set<Integer> possibleSums = new HashSet<>();
        possibleSums.add(0);
        possibleSums.add(nums[nums.length - 1]);

        for (int i = nums.length - 2; i >= 0; i--) {
            Set<Integer> newSums = new HashSet<>();
            for (int existing : possibleSums) {
                int s = existing + nums[i];

                if (s == target) {
                    return true;
                }

                newSums.add(s);
            }
            possibleSums.addAll(newSums);
        }

        return possibleSums.contains(target);
    }
}
