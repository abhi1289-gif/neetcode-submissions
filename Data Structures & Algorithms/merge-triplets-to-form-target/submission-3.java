class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
         boolean x = false;
        boolean y = false;
        boolean z = false;

        for (int[] t : triplets) {

            if (t[0] > target[0] ||
                t[1] > target[1] ||
                t[2] > target[2]) {
                continue;
            }

            if (t[0] == target[0]) x = true;
            if (t[1] == target[1]) y = true;
            if (t[2] == target[2]) z = true;

            if (x && y && z) return true;
        }

        return false;
    }
}
