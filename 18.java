//递归方式：k sum -> k-1 sum
//同时结合一些过滤手段
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int size = nums.length;
        if(size < 4){
            return ans;
        }
        Arrays.sort(nums);
        List<Integer> sol = new ArrayList<>();
        for(int i = 0; i < size - 3; i++){
            //avoid duplicate
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            //too small
            if(nums[i] + 3 * nums[size - 1] < target){
                continue;
            }
			//too big
            if(nums[i] * 4 > target){
                break;
            }
            
            sol.add(nums[i]);
            //System.out.format("4sum:%d%n", nums[i]);
            threeSum(ans, sol, nums, i + 1, target - nums[i], size);
            sol.remove(sol.size() - 1);
            
        }
        return ans;
    }
    
    private void threeSum(List<List<Integer>> ans, List<Integer> sol, int[] nums, int low, int target, int size){
        for(int i = low; i < size - 2; i++){
            if(i != low && nums[i] == nums[i - 1]){
                continue;
            }
            if(nums[i] + 2 * nums[size - 1] < target){
                continue;
            }
            if(nums[i] * 3 > target){
                break;
            }
            sol.add(nums[i]);
            //System.out.format("3sum:%d%n", nums[i]);
            twoSum(ans, sol, nums, i + 1, target - nums[i], size);
            sol.remove(sol.size() - 1);
        }
    }
    
    private void twoSum(List<List<Integer>> ans, List<Integer> sol, int[] nums, int low, int target, int size){
        int start = low;
        int end = size - 1;
        while(start < end){
            
            if(start != low && nums[start] == nums[start - 1]){
                start++;
                continue;
            }
            if(nums[start] + nums[end] == target){
                sol.add(nums[start]);
                sol.add(nums[end]);
                ans.add(new ArrayList<Integer>(sol));
                sol.remove(sol.size() - 1);
                sol.remove(sol.size() - 1);
                //sol.removeRange(sol.size() - 2, sol.size());
                start++;
            }
            else if(nums[start] + nums[end] < target){
                start++;
            }
            else{
                end--;
            }
        }
    }
}