package SearchAndSort;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeat {
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,7,7};
        System.out.println(firstNonRepeat(arr));
    }

    /***
     * Find first non repeated integer in an array.
     */
    public static int firstNonRepeat(int[] arr){
        if(arr.length == 1) return arr[0];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i ++){
            int num = arr[i];
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }
}
