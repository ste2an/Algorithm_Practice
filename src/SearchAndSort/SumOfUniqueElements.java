package SearchAndSort;

import java.util.HashMap;
import java.util.Map;

public class SumOfUniqueElements {
    public static void main(String[] args) {

    }

    /**
     description: You are given an integer array nums. The unique elements of an array are the elements that
     appear exactly once in the array.
     Return the sum of all the unique elements of nums.
     *
     */

    public static int targetSum(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }

        int sum = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                sum += entry.getKey();
            }
        }
        return sum;
    }
}
