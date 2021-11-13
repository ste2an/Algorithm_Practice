package SearchAndSort;

public class FindJudge {
    public static void main(String[] args) {

    }

    /**
     * description : Given an integer array nums sorted in non-decreasing order, return an array of the squares of each
     * number sorted in non-decreasing order.
     *
     */
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;

        for(int i = res.length - 1; i >= 0; i--){
            int squareL = nums[l] * nums[l];
            int squareR = nums[r] * nums[r];
            if(squareL < squareR){
                res[i] = squareR;
                r--;
            }else{
                res[i] = squareL;
                l++;
            }
        }
        return res;
    }
}
