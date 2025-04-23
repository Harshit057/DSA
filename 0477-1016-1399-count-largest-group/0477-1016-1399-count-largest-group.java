class Solution {
    public int countLargestGroup(int n) {
        int[] group = new int[37]; // Max digit sum for n = 9999 is 9+9+9+9 = 36
        int max = 0;

        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            group[sum]++;
            max = Math.max(max, group[sum]);
        }

        int count = 0;
        for (int freq : group) {
            if (freq == max) count++;
        }

        return count;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
