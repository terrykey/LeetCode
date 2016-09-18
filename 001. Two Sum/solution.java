public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map1.containsKey(nums[i]))
                map1.put(nums[i], i);
            else
                map2.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int find = target - nums[i];
            if(find == nums[i] && map2.containsKey(find)){
                result[0] = i;
                result[1] = map2.get(find);
                return result;                
            }
            else if(find != nums[i] && map1.containsKey(find)){
                result[0] = i;
                result[1] = map1.get(find);
                return result;
            }
        }
            
        return result;
    }
}