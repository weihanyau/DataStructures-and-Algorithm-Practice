using namespace std;

#include <vector>
#include <unordered_map>

class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        vector<int> results;
        unordered_map<int, int> count;
        vector<vector<int>> bucket(nums.size() + 1);

        for(int& num: nums){
            count[num]++;
        }

        for(const auto& [key, value]: count){
            bucket[value].push_back(key);
        }

        for(int i = bucket.size() - 1; i >= 0; i--){
            for(int j = 0; j < bucket[i].size(); j++){
                results.push_back(bucket[i][j]);
                if(results.size() == k){
                    return results;
                }
            }
        }

        return results;
    }
};