//使用HashMap记录遍历过的数值和其对应的index
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int len = nums.length;
        if(len == 0){
            return ans;
        }
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < len; i++){
            if(map.containsKey(target - nums[i])){
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}