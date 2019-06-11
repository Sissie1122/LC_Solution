//O(n^2)，先排序，再挑选符合要求的组合，不够快！！！
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int size = nums.length;
        if(size == 0){
            return ans;
        }
        Arrays.sort(nums);
        for(int i = 0; i < size - 2; i++){
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int target = -nums[i];
            int start = i + 1;
            int end = size - 1;
            while(start < end){
                if(start != i + 1 && nums[start] == nums[start - 1]){
                    start++;
                    continue;
                }
                if(nums[start] + nums[end] == target){
                    List<Integer> sol = new ArrayList<>();
                    sol.add(nums[i]);
                    sol.add(nums[start]);
                    sol.add(nums[end]);
                    ans.add(sol);
                    start++;
                }
                else if(nums[start] + nums[end] > target){
                    end--;
                }
                else{
                    start++;
                }
            }
        }
        return ans;
    }
}