using namespace std;

#include <vector>

class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> result(nums.size());

        result[0] = nums[0];
        for(int i = 1; i < nums.size(); i++){
            result[i] = result[i - 1] * nums[i];
        }

        int right = nums[nums.size() - 1];
        result[nums.size() - 1] = result[nums.size() - 2];
        for(int i = nums.size() - 2; i > 0; i--){
            result[i] = right * result[i - 1];
            right *= nums[i];
        }
        result[0] = right;

        return result;
    }
};