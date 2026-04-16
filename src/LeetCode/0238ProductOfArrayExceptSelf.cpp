using namespace std;

#include <vector>

class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> prefixMul(nums.size());
        vector<int> suffixMul(nums.size());
        vector<int> result(nums.size());

        prefixMul[0] = nums[0];
        for(int i = 1; i < nums.size(); i++){
            prefixMul[i] = prefixMul[i - 1] * nums[i];
        }

        suffixMul[nums.size() - 1] = nums[nums.size() - 1];
        for(int i = nums.size() - 2; i >= 0; i--){
            suffixMul[i] = suffixMul[i + 1] * nums[i];
        }

        for(int i = 0; i < nums.size(); i++){
            if(i == 0) {
                result[i] = suffixMul[i + 1];
                continue;
            }
            if(i == (nums.size() - 1)){
                result[i] = prefixMul[i - 1];
                continue;
            }
            result[i] = prefixMul[i - 1] * suffixMul[i + 1];
        }

        return result;
    }
};