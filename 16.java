//和上一题解法类似，先排序，再依次寻找组合，O(n^2)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int size = nums.length;
        if(size == 0){
            return 0;
        }
        int ans = 0;
        int dis = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < size - 2; i++){
            int tmp = target - nums[i];
            int start = i + 1;
            int end = size - 1;
            while(start < end){
                int sum = nums[start] + nums[end];
                if(sum == tmp){
                    return target;
                }
                else{
                    if(Math.abs(tmp - sum) < dis){
                        dis = Math.abs(tmp - sum);
                        ans = nums[i] + sum;
                    }
                    if(sum < tmp){
                        start++;
                    }
                    else{
                        end--;
                    }
                }
                
            }
        }
        return ans;
    }
}